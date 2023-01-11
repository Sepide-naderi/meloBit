package com.example.music_player.ui.fragment;

import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
        import com.example.music_player.R;

public class SearchFragment extends Fragment {

    public SearchFragment(){

    }

    View view;
    AppCompatButton btn_artist, btn_song;
    AppCompatEditText et_search;
    ConstraintLayout cl_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        initVies();
        changeTypeSearch();
        initRecyclerView();



        return view;
    }

    private void initVies() {
        btn_artist = view.findViewById(R.id.btn_artist);
        btn_song = view.findViewById(R.id.btn_song);
        et_search = view.findViewById(R.id.et_search);
        cl_search = view.findViewById(R.id.cl_search);
        cl_search.setOnClickListener(view -> {
           et_search.requestFocus();
        });
    }

    private void changeTypeSearch() {
        btn_artist.setOnClickListener(view -> {
            view.setBackgroundResource(R.drawable.shape_select);
            btn_song.setBackgroundResource(R.drawable.shape_unselect);
        });

        btn_song.setOnClickListener(view -> {
            view.setBackgroundResource(R.drawable.shape_select);
            btn_artist.setBackgroundResource(R.drawable.shape_unselect);
        });
    }

    private void initRecyclerView() {

    }
}