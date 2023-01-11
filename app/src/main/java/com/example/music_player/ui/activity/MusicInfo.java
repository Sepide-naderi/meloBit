package com.example.music_player.ui.activity;

import static com.example.music_player.main_class.Utils.setImageToView;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.music_player.R;

public class MusicInfo extends AppCompatActivity {

    AppCompatImageView iv_cover;
    TextView tv_songName, tv_artistName, tv_countDownload;
    ConstraintLayout cl_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);
        initView();
        setDataToView();
    }

    private void initView() {
        iv_cover = findViewById(R.id.iv_cover);
        tv_songName = findViewById(R.id.tv_songName);
        tv_artistName = findViewById(R.id.tv_artistName);
        tv_countDownload = findViewById(R.id.tv_countDownload);
        cl_main = findViewById(R.id.cl_main);
    }

    private void setDataToView() {
        setImageToView(iv_cover, getIntent().getStringExtra("cover"));
        Glide.with(this)
                .load(getIntent().getStringExtra("cover"))
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        cl_main.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

        tv_songName.setText(getIntent().getStringExtra("songName"));
        tv_artistName.setText(getIntent().getStringExtra("artistName"));
        tv_countDownload.setText(getIntent().getStringExtra("countDownload"));
    }
}