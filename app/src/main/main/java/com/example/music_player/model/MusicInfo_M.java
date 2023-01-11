package com.example.music_player.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MusicInfo_M {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }










    public static class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("artists")
        @Expose
        private List<Artist> artists = null;
        @SerializedName("audio")
        @Expose
        private Audio audio;
        @SerializedName("downloadCount")
        @Expose
        private String downloadCount;
        @SerializedName("duration")
        @Expose
        private Integer duration;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private Image image;
        @SerializedName("releaseDate")
        @Expose
        private String releaseDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Artist> getArtists() {
            return artists;
        }

        public void setArtists(List<Artist> artists) {
            this.artists = artists;
        }

        public Audio getAudio() {
            return audio;
        }

        public void setAudio(Audio audio) {
            this.audio = audio;
        }

        public String getDownloadCount() {
            return downloadCount;
        }

        public void setDownloadCount(String downloadCount) {
            this.downloadCount = downloadCount;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

    }

    public class Artist {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("fullName")
        @Expose
        private String fullName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }


    }

    public static class Audio {

        @SerializedName("medium")
        @Expose
        private Medium medium;

        public Medium getMedium() {
            return medium;
        }

        public void setMedium(Medium medium) {
            this.medium = medium;
        }

    }

    public static class Cover {

        @SerializedName("url")
        @Expose
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    public static class Image {

        @SerializedName("cover")
        @Expose
        private Cover cover;

        public Cover getCover() {
            return cover;
        }

        public void setCover(Cover cover) {
            this.cover = cover;
        }

    }

    public static class Medium {

        @SerializedName("url")
        @Expose
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


}





