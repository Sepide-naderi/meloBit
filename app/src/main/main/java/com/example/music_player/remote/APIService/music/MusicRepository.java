package com.example.music_player.remote.APIService.music;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.music_player.model.MusicInfo_M;
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

    public void getTopMusic(int count) {

        Observable<MusicInfo_M> mObservable = apiService.getTopMusic();
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

    public void getNewSongs(int count) {

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



    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                            { Getter }    { And }    { Setter }                                           */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public MutableLiveData<MusicInfo_M> getMutableLiveData_musicInfo() {
        return mutableLiveData_musicInfo;
    }
}
