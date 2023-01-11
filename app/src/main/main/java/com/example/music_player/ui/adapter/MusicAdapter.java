package com.example.music_player.ui.adapter;

import static com.example.music_player.main_class.Utils.setImageToView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.MusicInfo_M;
import com.example.music_player.ui.activity.CategoriesInfo;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private List<MusicInfo_M.Result> myList;
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

    public MusicAdapter(List<MusicInfo_M.Result> myList, Activity activity) {
        this.myList = myList;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return myList.size();
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
        MusicInfo_M.Result model = myList.get(position);
        holder.tv_artistName.setText(model.getTitle());
        holder.tv_songName.setText(model.getArtists().get(0).getFullName());
        setImageToView(holder.iv_cover, model.getImage().getCover().getUrl());
    }
}