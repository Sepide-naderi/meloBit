package com.example.music_player.ui.activity;

import static com.example.music_player.main_class.Utils.setImageToView;
import static com.example.music_player.ui.activity.MainActivity.exoPlayerAudio;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.music_player.R;
import com.example.music_player.model.Lyrics_M;
import com.example.music_player.model.MusicInfo_M;
import com.example.music_player.remote.APIService.music.MusicRepository;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.ui.PlayerControlView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MusicInfo extends AppCompatActivity {

    AppCompatImageView iv_cover;
    TextView tv_songName, tv_artistName, tv_countDownload, tv_date, tv_lyrics;
    ConstraintLayout cl_main;
    boolean isFast = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);
        initView();
        setDataToView();
        player();
    }

    private void initView() {
        iv_cover = findViewById(R.id.iv_cover);
        tv_songName = findViewById(R.id.tv_songName);
        tv_artistName = findViewById(R.id.tv_artistName);
        tv_countDownload = findViewById(R.id.tv_countDownload);
        tv_date = findViewById(R.id.tv_date);
        tv_lyrics = findViewById(R.id.tv_lyrics);
        cl_main = findViewById(R.id.cl_main);
    }

    @SuppressLint("SetTextI18n")
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
        try {
            tv_date.setText("date: " + getDate());
        } catch (ParseException ignored) {

        }


        // get and set Lyrics
        MusicRepository musicRepository = new MusicRepository(this);
        musicRepository.getLyrics(getIntent().getStringExtra("songID"));
        musicRepository.getMutableLiveData_lyrics().observe(this, lyrics_m -> {
            tv_lyrics.setText(lyrics_m.getLyrics());
        });
    }

    private String getDate() throws ParseException {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Date date = inputFormat.parse(getIntent().getStringExtra("date"));
        return outputFormat.format(date);
    }




    private void player() {
        PlayerControlView playerViewAudio = findViewById(R.id.PV_AudioFile);
        initializeAudioPlayer(playerViewAudio, exoPlayerAudio, getIntent().getStringExtra("audioURL"));
    }


    private void initializeAudioPlayer(PlayerControlView playerViewAudio, ExoPlayer exoPlayerAudio, String url) {
        playerViewAudio.setPlayer(exoPlayerAudio);

        MediaItem mediaItemAudio = new MediaItem.Builder()
                .setUri(url)
                .setLiveConfiguration(new MediaItem.LiveConfiguration.Builder().setMaxPlaybackSpeed(1.02f).build())
                .build();
        exoPlayerAudio.setMediaItem(mediaItemAudio);
        exoPlayerAudio.prepare();
        AppCompatImageView iv_fast = playerViewAudio.findViewById(R.id.IV_Fast);
        AppCompatImageView iv_Rewind =playerViewAudio.findViewById(R.id.IV_Rewind);

        iv_fast.setOnClickListener(view -> {
            isFast = !isFast;
            if (isFast) {
                changeSpeedAudio(2, exoPlayerAudio);
            }else {
                changeSpeedAudio(1, exoPlayerAudio);
            }
        });



        iv_Rewind.setOnClickListener(view1 -> {
            exoRewind(exoPlayerAudio);
        });
    }

    private void changeSpeedAudio(int speed, ExoPlayer exoPlayer) {
        PlaybackParameters param = new PlaybackParameters(speed);
        exoPlayer.setPlaybackParameters(param);
    }

    private void exoRewind(ExoPlayer exoPlayer) {
        exoPlayer.seekTo(exoPlayer.getCurrentPosition() - 10000); // -10 Sec
    }

}