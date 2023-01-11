package com.example.music_player.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.HomePost_M;
import com.example.music_player.ui.adapter.HomePostAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View view;

    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView();



        return view;
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        HomePostAdapter adapter = new HomePostAdapter(getPost(), getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private List<HomePost_M> getPost() {
        List<HomePost_M> list = new ArrayList<>();
        list.add(new HomePost_M(getString(R.string.HomePostType_new), R.drawable.new_song));
        list.add(new HomePost_M(getString(R.string.HomePostType_topSingers), R.drawable.top_singers));
        list.add(new HomePost_M(getString(R.string.HomePostType_topSongDay), R.drawable.top_song_day));
        list.add(new HomePost_M(getString(R.string.HomePostType_topSongWeek), R.drawable.top_song_week));
        return list;
    }
}
