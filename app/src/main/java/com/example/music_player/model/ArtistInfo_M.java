package com.example.music_player.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistInfo_M {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
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

    public static class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("followersCount")
        @Expose
        private Integer followersCount;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("sumSongsDownloadsCount")
        @Expose
        private String sumSongsDownloadsCount;
        @SerializedName("image")
        @Expose
        private Image image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getFollowersCount() {
            return followersCount;
        }

        public void setFollowersCount(Integer followersCount) {
            this.followersCount = followersCount;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getSumSongsDownloadsCount() {
            return sumSongsDownloadsCount;
        }

        public void setSumSongsDownloadsCount(String sumSongsDownloadsCount) {
            this.sumSongsDownloadsCount = sumSongsDownloadsCount;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

    }
}
