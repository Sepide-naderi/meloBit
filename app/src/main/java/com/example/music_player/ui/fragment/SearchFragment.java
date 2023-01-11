package com.example.music_player.ui.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.ArtistInfo_M;
import com.example.music_player.model.Search_M;
import com.example.music_player.remote.APIService.SearchRepository;
import com.example.music_player.ui.adapter.ArtistAdapter;
import com.example.music_player.ui.adapter.MusicAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SearchFragment extends Fragment {

    public SearchFragment(){

    }

    View view;
    AppCompatButton btn_artist, btn_song;
    AppCompatEditText et_search;
    RecyclerView recyclerView;
    ArrayList<Search_M.Artist> arrayList_artis = new ArrayList<>();
    ArrayList<Search_M.Song> arrayList_song = new ArrayList<>();
    MusicAdapter musicAdapter;
    ArtistAdapter artistAdapter;
    boolean isReady = false;
    int mode = 1; // mode 1: show song, mode2: show artist



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        initVies();
        changeTypeSearch();
        search(et_search);



        return view;
    }

    private void initVies() {
        btn_artist = view.findViewById(R.id.btn_artist);
        btn_song = view.findViewById(R.id.btn_song);
        et_search = view.findViewById(R.id.et_search);
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    private void changeTypeSearch() {
        btn_artist.setOnClickListener(view -> {
            if (isReady) {
                mode = 2;
                view.setBackgroundResource(R.drawable.shape_select);
                btn_song.setBackgroundResource(R.drawable.shape_unselect);
                changeDataToRecyclerView();
            }else {
                Toast.makeText(getContext(), "هیچ داده ای وجود ندارد", Toast.LENGTH_SHORT).show();
            }
        });

        btn_song.setOnClickListener(view -> {
            if (isReady) {
                view.setBackgroundResource(R.drawable.shape_select);
                btn_artist.setBackgroundResource(R.drawable.shape_unselect);
                mode = 1;
                changeDataToRecyclerView();
            }else {
                Toast.makeText(getContext(), "هیچ داده ای وجود ندارد", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        artistAdapter = new ArtistAdapter(null, arrayList_artis, getActivity());
        musicAdapter = new MusicAdapter(null, arrayList_song, getActivity());
        changeDataToRecyclerView(); // Default: musicAdapter
    }

    private void changeDataToRecyclerView() {
        if (mode == 1) {
            recyclerView.setAdapter(musicAdapter);
        }else  if (mode == 2) {
            recyclerView.setAdapter(artistAdapter);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }








    public void search(AppCompatEditText editText) {
        editText.toString().matches("[a-zA-Z ]+");

        editText.addTextChangedListener(
                new TextWatcher() {
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }


                    private Timer timer = new Timer();
                    private final long DELAY = 1000; // Milliseconds

                    @Override
                    public void afterTextChanged(final Editable s) {
                        timer.cancel();
                        timer = new Timer();
                        timer.schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        getActivity().runOnUiThread(() -> {
                                            arrayList_artis.clear();
                                            arrayList_song.clear();
                                            if (!String.valueOf(s).equals("")) {
                                                isReady = false;
                                                searchAS(String.valueOf(s));
                                            }
                                        });
                                    }
                                },
                                DELAY
                        );
                    }
                }
        );




    }

    private void searchAS(String text) {
        SearchRepository searchRepository = new SearchRepository(getContext());
        searchRepository.searchAS(text);
        try {
            searchRepository.getMutableLiveData_search().observe(requireActivity(), search_m -> {
                for (int i=0; i < search_m.getResults().size(); i++) {
                    if (search_m.getResults().get(i).getType().equals("song")) {
                        arrayList_song.add(search_m.getResults().get(i).getSong());
                    }else if (search_m.getResults().get(i).getType().equals("artist")) {
                        arrayList_artis.add(search_m.getResults().get(i).getArtist());
                    }
                }
                isReady = true;
                initRecyclerView();
            });
        }catch (IllegalStateException ignored) {

        }



    }






}