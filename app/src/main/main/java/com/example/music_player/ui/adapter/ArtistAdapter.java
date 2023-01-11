package com.example.music_player.ui.adapter;

import android.app.Activity;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_player.R;
import com.example.music_player.model.ArtistInfo_M;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {

    private List<ArtistInfo_M.Result> myList;
    Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nickname;
        public TextView message;


        public MyViewHolder(View view) {
            super(view);

//            nickname = (TextView) view.findViewById(R.id.nickname);
//            message = (TextView) view.findViewById(R.id.message);


        }
    }

    public ArtistAdapter(List<ArtistInfo_M.Result> myList, Activity activity) {
        this.myList = myList;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    @NonNull
    @Override
    public ArtistAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_music, parent, false);


        return new ArtistAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ArtistAdapter.MyViewHolder holder, final int position) {
        ArtistInfo_M.Result m = myList.get(position);
//        holder.nickname.setText(m.get());
//        holder.message.setText(m.getMessage());
    }
}
