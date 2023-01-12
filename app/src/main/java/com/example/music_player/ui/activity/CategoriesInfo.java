package com.example.music_player.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.ArtistInfo_M;
import com.example.music_player.model.MusicInfo_M;
import com.example.music_player.remote.APIService.music.MusicRepository;
import com.example.music_player.ui.adapter.ArtistAdapter;
import com.example.music_player.ui.adapter.HomePostAdapter;
import com.example.music_player.ui.adapter.MusicAdapter;


public class CategoriesInfo extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_info);

        String categoriesType = getIntent().getStringExtra("categories");
        TextView textView = findViewById(R.id.title);
        recyclerView = findViewById(R.id.recyclerView);

        textView.setText(categoriesType);

         if (categoriesType.equals(getString(R.string.HomePostType_new))) {
             getNewSong();
         }else if (categoriesType.equals(getString(R.string.HomePostType_topSingers))) {
             getTopSingers();
         }else if (categoriesType.equals(getString(R.string.HomePostType_topSongDay))) {
             getTopSongDay();
         } else if (categoriesType.equals(getString(R.string.HomePostType_topSongWeek))) {
             getTopSongWeek();
         }

    }



    private void getNewSong() {
        MusicRepository musicRepository = new MusicRepository(this);
        musicRepository.getNewSongs();
        musicRepository.getMutableLiveData_musicInfo().observe(this, musicInfo_m -> {
            MusicAdapter adapter = new MusicAdapter(musicInfo_m.getResults(), null, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    };

    private void getTopSongDay() {
        MusicRepository musicRepository = new MusicRepository(this);
        musicRepository.getTopSongDay();
        musicRepository.getMutableLiveData_musicInfo().observe(this, musicInfo_m -> {
            MusicAdapter adapter = new MusicAdapter(musicInfo_m.getResults(), null, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    };

    private void getTopSongWeek() {
        MusicRepository musicRepository = new MusicRepository(this);
        musicRepository.getTopSongWeek();
        musicRepository.getMutableLiveData_musicInfo().observe(this, musicInfo_m -> {
            MusicAdapter adapter = new MusicAdapter(musicInfo_m.getResults(), null, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    };

    private void getTopSingers() {
        MusicRepository musicRepository = new MusicRepository(this);
        musicRepository.getTopSingers();
        musicRepository.getMutableLiveData_artistInfo().observe(this, artistInfo_m -> {
            ArtistAdapter adapter = new ArtistAdapter(artistInfo_m.getResults(), null, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    };


}

