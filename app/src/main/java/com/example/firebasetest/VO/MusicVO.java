package com.example.firebasetest.VO;

public class MusicVO {

    private String song;
    private String singer;
    private int img;

    public MusicVO(String song, String singer, int img) {
        this.song = song;
        this.singer = singer;
        this.img = img;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
