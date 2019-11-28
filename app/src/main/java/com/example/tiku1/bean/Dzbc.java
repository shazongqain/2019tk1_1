package com.example.tiku1.bean;

public class Dzbc {
    private String luhao,kaishi,jieshu,lichenh,piaojia,shijian,shijian1,zhongjian1,zhongjian2;

    public Dzbc(String luhao, String kaishi, String jieshu, String lichenh, String piaojia, String shijian, String shijian1, String zhongjian1, String zhongjian2) {
        this.luhao = luhao;
        this.kaishi = kaishi;
        this.jieshu = jieshu;
        this.lichenh = lichenh;
        this.piaojia = piaojia;
        this.shijian = shijian;
        this.shijian1 = shijian1;
        this.zhongjian1 = zhongjian1;
        this.zhongjian2 = zhongjian2;
    }

    @Override
    public String toString() {
        return "Dzbc{" +
                "luhao='" + luhao + '\'' +
                ", kaishi='" + kaishi + '\'' +
                ", jieshu='" + jieshu + '\'' +
                ", lichenh='" + lichenh + '\'' +
                ", piaojia='" + piaojia + '\'' +
                ", shijian='" + shijian + '\'' +
                ", shijian1='" + shijian1 + '\'' +
                ", zhongjian1='" + zhongjian1 + '\'' +
                ", zhongjian2='" + zhongjian2 + '\'' +
                '}';
    }

    public String getLuhao() {
        return luhao;
    }

    public void setLuhao(String luhao) {
        this.luhao = luhao;
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

    public String getLichenh() {
        return lichenh;
    }

    public void setLichenh(String lichenh) {
        this.lichenh = lichenh;
    }

    public String getPiaojia() {
        return piaojia;
    }

    public void setPiaojia(String piaojia) {
        this.piaojia = piaojia;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getShijian1() {
        return shijian1;
    }

    public void setShijian1(String shijian1) {
        this.shijian1 = shijian1;
    }

    public String getZhongjian1() {
        return zhongjian1;
    }

    public void setZhongjian1(String zhongjian1) {
        this.zhongjian1 = zhongjian1;
    }

    public String getZhongjian2() {
        return zhongjian2;
    }

    public void setZhongjian2(String zhongjian2) {
        this.zhongjian2 = zhongjian2;
    }
}
