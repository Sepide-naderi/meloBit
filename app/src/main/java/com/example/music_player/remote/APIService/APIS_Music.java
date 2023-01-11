package com.example.music_player.remote.APIService;


import com.example.music_player.model.MusicInfo_M;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Path;
import retrofit2.http.GET;

public interface APIS_Music {

    @GET("song/top/day/0/1")
    Observable<MusicInfo_M> getTopMusic();

    @GET("song/new/0/11")
    Observable<MusicInfo_M> getNewSongs();

    @GET("artist/trending/0/4")
    Observable<MusicInfo_M> getTopSingers();

    @GET("song/top/day/0/10")
    Observable<MusicInfo_M> getTopSongDay();

    @GET("song/top/week/0/10")
    Observable<MusicInfo_M> getTopSongWeek();

}
