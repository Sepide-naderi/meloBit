package com.example.music_player.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.music_player.R;
import com.example.music_player.model.HomePost_M;
import com.example.music_player.ui.activity.CategoriesInfo;

import java.util.List;

public class HomePostAdapter extends RecyclerView.Adapter<HomePostAdapter.MyViewHolder> {
    private List<HomePost_M> myList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView iv_cover;


        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_title);
            iv_cover = view.findViewById(R.id.iv_cover);
        }
    }

    public HomePostAdapter(List<HomePost_M> myList, Activity activity) {
        this.myList = myList;
        this.activity= activity;
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    @NonNull
    @Override
    public HomePostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_post, parent, false);
        return new HomePostAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HomePostAdapter.MyViewHolder holder, final int position) {
        HomePost_M model = myList.get(position);
        holder.title.setText(model.getTitle());
        holder.iv_cover.setBackgroundResource(model.getImage());

        holder.itemView.setOnClickListener(view -> {
            activity.startActivity(new Intent(activity, CategoriesInfo.class).putExtra("categories", model.getTitle()));
        });
    }
}