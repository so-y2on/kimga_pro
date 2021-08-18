package com.example.firebasetest.VO;

public class AlarmVO {

    String ampm;
    String name;
    String time;

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public AlarmVO() {
    }

    public AlarmVO(String ampm, String name, String time) {
        this.ampm = ampm;
        this.name = name;
        this.time = time;
    }
}
