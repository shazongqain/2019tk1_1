package com.example.tiku1.bean;

public class Addtime {
    private String time;

    public Addtime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Addtime{" +
                "time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
