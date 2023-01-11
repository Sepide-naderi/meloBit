package com.example.music_player.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search_M {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public class Artist {

        @SerializedName("id")
        @Expose
        private String id;
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

    public class Artist__1 {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("sumSongsDownloadsCount")
        @Expose
        private String sumSongsDownloadsCount;
        @SerializedName("image")
        @Expose
        private Image__1 image;

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

        public String getSumSongsDownloadsCount() {
            return sumSongsDownloadsCount;
        }

        public void setSumSongsDownloadsCount(String sumSongsDownloadsCount) {
            this.sumSongsDownloadsCount = sumSongsDownloadsCount;
        }

        public Image__1 getImage() {
            return image;
        }

        public void setImage(Image__1 image) {
            this.image = image;
        }

    }

    public class Audio {

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

    public class Cover {

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

    public class Cover__1 {

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

    public class Cover__2 {

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



    public class Image {

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

    public class Image__1 {

        @SerializedName("cover")
        @Expose
        private Cover__1 cover;

        public Cover__1 getCover() {
            return cover;
        }

        public void setCover(Cover__1 cover) {
            this.cover = cover;
        }

    }

    public class Image__2 {

        @SerializedName("cover")
        @Expose
        private Cover__2 cover;

        public Cover__2 getCover() {
            return cover;
        }

        public void setCover(Cover__2 cover) {
            this.cover = cover;
        }

    }

    public class Medium {

        @SerializedName("fingerprint")
        @Expose
        private String fingerprint;
        @SerializedName("url")
        @Expose
        private String url;

        public String getFingerprint() {
            return fingerprint;
        }

        public void setFingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    public class Result {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("artist")
        @Expose
        private Artist artist;
        @SerializedName("position")
        @Expose
        private Integer position;
        @SerializedName("song")
        @Expose
        private Song song;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public Song getSong() {
            return song;
        }

        public void setSong(Song song) {
            this.song = song;
        }

    }

    public class Song {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("artists")
        @Expose
        private List<Artist__1> artists = null;
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
        private Image__2 image;
        @SerializedName("releaseDate")
        @Expose
        private String releaseDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Artist__1> getArtists() {
            return artists;
        }

        public void setArtists(List<Artist__1> artists) {
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

        public Image__2 getImage() {
            return image;
        }

        public void setImage(Image__2 image) {
            this.image = image;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

    }
}
