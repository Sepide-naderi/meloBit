package com.example.music_player.remote.APIService.music;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.music_player.model.ArtistInfo_M;
import com.example.music_player.model.Lyrics_M;
import com.example.music_player.model.MusicInfo_M;
import com.example.music_player.model.Search_M;
import com.example.music_player.remote.APIService.APIS_Music;
import com.example.music_player.remote.httpServer.RetroClass;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MusicRepository {

    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                       { Variable }    { Variable }    { Variable }                                       */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    private final MutableLiveData<MusicInfo_M> mutableLiveData_musicInfo = new MutableLiveData<>();
    private final MutableLiveData<Lyrics_M> mutableLiveData_lyrics = new MutableLiveData<>();
    private final MutableLiveData<ArtistInfo_M> mutableLiveData_artistInfo = new MutableLiveData<>();
    private Context context;
    APIS_Music apiService;


    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                   { Constructor }    { Constructor }    { Constructor }                                  */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public MusicRepository(Context context) {
        this.context = context;
        apiService = RetroClass.getAPIS_Music();
    }



    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                         { Methods }    { Methods }    { Methods }                                        */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public void getNewSongs() {

        Observable<MusicInfo_M> mObservable = apiService.getNewSongs();
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicInfo_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MusicInfo_M musicInfo_m) {
                        Log.d("kjp8696hghfugf", ":))))");
                        getMutableLiveData_musicInfo().postValue(musicInfo_m);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("kjp8696hghfugf", ":((((:  " + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getTopSongDay() {

        Observable<MusicInfo_M> mObservable = apiService.getTopSongDay();
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicInfo_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MusicInfo_M musicInfo_m) {
                        getMutableLiveData_musicInfo().postValue(musicInfo_m);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getTopSongWeek() {

        Observable<MusicInfo_M> mObservable = apiService.getTopSongWeek();
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicInfo_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MusicInfo_M musicInfo_m) {
                        getMutableLiveData_musicInfo().postValue(musicInfo_m);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getTopSingers() {

        Observable<ArtistInfo_M> mObservable = apiService.getTopSingers();
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtistInfo_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtistInfo_M artistInfo_m) {
                        getMutableLiveData_artistInfo().postValue(artistInfo_m);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getLyrics(String song_id) {

        Observable<Lyrics_M> mObservable = apiService.getLyrics(song_id);
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Lyrics_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Lyrics_M lyrics_m) {
                        getMutableLiveData_lyrics().postValue(lyrics_m);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                            { Getter }    { And }    { Setter }                                           */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public MutableLiveData<MusicInfo_M> getMutableLiveData_musicInfo() {
        return mutableLiveData_musicInfo;
    }

    public MutableLiveData<Lyrics_M> getMutableLiveData_lyrics() {
        return mutableLiveData_lyrics;
    }

    public MutableLiveData<ArtistInfo_M> getMutableLiveData_artistInfo() {
        return mutableLiveData_artistInfo;
    }
}
