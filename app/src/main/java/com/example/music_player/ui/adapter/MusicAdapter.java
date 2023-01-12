package com.example.music_player.ui.adapter;

import static com.example.music_player.main_class.Utils.setImageToView;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.ArtistInfo_M;
import com.example.music_player.model.MusicInfo_M;
import com.example.music_player.model.Search_M;
import com.example.music_player.ui.activity.CategoriesInfo;
import com.example.music_player.ui.activity.MusicInfo;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private List<MusicInfo_M.Result> myList;
    private List<Search_M.Song> list_search_song;
    Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_artistName, tv_songName;
        public AppCompatImageView iv_cover;

        public MyViewHolder(View view) {
            super(view);
            tv_artistName = view.findViewById(R.id.tv_artistName);
            tv_songName = view.findViewById(R.id.tv_songName);
            iv_cover = view.findViewById(R.id.iv_cover);
        }
    }



    public MusicAdapter(List<MusicInfo_M.Result> myList, List<Search_M.Song> list_search_song, Activity activity) {
        this.myList = myList;
        this.list_search_song = list_search_song;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        if (myList != null) {
            return myList.size();
        }else if (list_search_song != null) {
            return list_search_song.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public MusicAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_music, parent, false);


        return new MusicAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MusicAdapter.MyViewHolder holder, final int position) {
        if (myList != null) { // Return song for CategoriesInfo
            MusicInfo_M.Result model = myList.get(position);
            holder.tv_artistName.setText(model.getTitle());
            holder.tv_songName.setText(model.getArtists().get(0).getFullName());
            setImageToView(holder.iv_cover, model.getImage().getCover().getUrl());

            holder.itemView.setOnClickListener(view -> {
                activity.startActivity(new Intent(activity, MusicInfo.class)
                        .putExtra("cover", model.getImage().getCover().getUrl())
                        .putExtra("songName", model.getTitle())
                        .putExtra("artistName", model.getArtists().get(0).getFullName())
                        .putExtra("countDownload", model.getDownloadCount())
                        .putExtra("songID", model.getId())
                );
            });
        }else { // Return song for Search
            Search_M.Song model = list_search_song.get(position);
            holder.tv_artistName.setText(model.getTitle());
            holder.tv_songName.setText(model.getArtists().get(0).getFullName());
            setImageToView(holder.iv_cover, model.getImage().getCover().getUrl());

            holder.itemView.setOnClickListener(view -> {
                activity.startActivity(new Intent(activity, MusicInfo.class)
                        .putExtra("cover", model.getImage().getCover().getUrl())
                        .putExtra("songName", model.getTitle())
                        .putExtra("artistName", model.getArtists().get(0).getFullName())
                        .putExtra("countDownload", model.getDownloadCount())
                        .putExtra("songID", model.getId())
                );
            });
        }

    }
}