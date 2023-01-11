package com.example.music_player.ui.adapter;

import static com.example.music_player.main_class.Utils.setImageToView;

import android.app.Activity;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.ArtistInfo_M;
import com.example.music_player.model.Search_M;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {

    private List<ArtistInfo_M.Result> myList;
    private List<Search_M.Artist> list_search_artist;
    Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name, tv_download_count;
        public AppCompatImageView iv_avatar;


        public MyViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            tv_download_count = view.findViewById(R.id.tv_download_count);
            iv_avatar = view.findViewById(R.id.iv_avatar);
        }
    }

    public ArtistAdapter(List<ArtistInfo_M.Result> myList, List<Search_M.Artist> list_search_artist, Activity activity) {
        this.myList = myList;
        this.list_search_artist = list_search_artist;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        if (myList != null) {
            return myList.size();
        }else if (list_search_artist != null) {
            return list_search_artist.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public ArtistAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist, parent, false);


        return new ArtistAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ArtistAdapter.MyViewHolder holder, final int position) {
        if (myList != null) { // Return Artist for CategoriesInfo
            ArtistInfo_M.Result model = myList.get(position);
            holder.tv_name.setText(model.getFullName());
            holder.tv_download_count.setText(model.getSumSongsDownloadsCount());
            setImageToView(holder.iv_avatar, model.getImage().getCover().getUrl());
        }else { // Return Artist for Search
            Search_M.Artist model = list_search_artist.get(position);
            holder.tv_name.setText(model.getFullName());
            holder.tv_download_count.setText(model.getSumSongsDownloadsCount());
            setImageToView(holder.iv_avatar, model.getImage().getCover().getUrl());
        }
    }
}
