package com.example.tiku1.bean;

import org.litepal.crud.LitePalSupport;

public class Tjdd extends LitePalSupport {
    private String name,time,luxian,kaishi,jieshu;

    public Tjdd() {
    }

    public Tjdd(String name, String time, String luxian, String kaishi, String jieshu) {
        this.name = name;
        this.time = time;
        this.luxian = luxian;
        this.kaishi = kaishi;
        this.jieshu = jieshu;
    }

    @Override
    public String toString() {
        return "Tjdd{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", luxian='" + luxian + '\'' +
                ", kaishi='" + kaishi + '\'' +
                ", jieshu='" + jieshu + '\'' +
                '}';
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

    public String getLuxian() {
        return luxian;
    }

    public void setLuxian(String luxian) {
        this.luxian = luxian;
    }

    public String getKaishi() {
        return kaishi;
    }

    public void setKaishi(String kaishi) {
        this.kaishi = kaishi;
    }

    public String getJieshu() {
        return jieshu;
    }

    public void setJieshu(String jieshu) {
        this.jieshu = jieshu;
    }
}
