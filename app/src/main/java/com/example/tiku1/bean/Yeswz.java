package com.example.tiku1.bean;

public class Yeswz {
    private String chepia,yuanyi;

    public Yeswz(String chepia, String yuanyi) {
        this.chepia = chepia;
        this.yuanyi = yuanyi;
    }


    @Override
    public String toString() {
        return "Yeswz{" +
                "chepia='" + chepia + '\'' +
                ", yuanyi='" + yuanyi + '\'' +
                '}';
    }

    public String getChepia() {
        return chepia;
    }

    public void setChepia(String chepia) {
        this.chepia = chepia;
    }

    public String getYuanyi() {
        return yuanyi;
    }

    public void setYuanyi(String yuanyi) {
        this.yuanyi = yuanyi;
    }
}
