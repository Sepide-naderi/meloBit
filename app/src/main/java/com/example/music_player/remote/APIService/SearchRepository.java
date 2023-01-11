package com.example.music_player.remote.APIService;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.music_player.model.MusicInfo_M;
import com.example.music_player.model.Search_M;
import com.example.music_player.remote.httpServer.RetroClass;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchRepository {

    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                       { Variable }    { Variable }    { Variable }                                       */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    private final MutableLiveData<Search_M> mutableLiveData_search = new MutableLiveData<>();
    private Context context;
    APIS_Music apiService;


    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                   { Constructor }    { Constructor }    { Constructor }                                  */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public SearchRepository(Context context) {
        this.context = context;
        apiService = RetroClass.getAPIS_Music();
    }



    /*--------------------------------------------------------------------------------------------------------------------------*/
    /*                                         { Methods }    { Methods }    { Methods }                                        */
    /*--------------------------------------------------------------------------------------------------------------------------*/

    public void searchAS(String text) {

        Observable<Search_M> mObservable = apiService.searchAS(text);
        mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Search_M>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Search_M search_m) {
                        getMutableLiveData_search().postValue(search_m);
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

    public MutableLiveData<Search_M> getMutableLiveData_search() {
        return mutableLiveData_search;
    }
}
