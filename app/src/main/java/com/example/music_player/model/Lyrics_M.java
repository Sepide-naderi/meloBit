package com.example.music_player.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lyrics_M {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lyrics")
    @Expose
    private String lyrics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

}
