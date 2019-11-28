package com.example.tiku1.bean;

public class Yanse {
    private int yanse;

    public Yanse(int yanse) {
        this.yanse = yanse;
    }

    @Override
    public String toString() {
        return "Yanse{" +
                "yanse=" + yanse +
                '}';
    }

    public int getYanse() {
        return yanse;
    }

    public void setYanse(int yanse) {
        this.yanse = yanse;
    }
}
