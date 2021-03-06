package com.github.mrduoduo2.models;

public class Suv {
     private int sub_id;
     private int car;
     private String cha_height;
     private String tyre;
     private String direction_sys;
     private String damper;

    public Suv() {
    }

    public Suv(int sub_id, int car, String cha_height, String tyre, String direction_sys, String damper) {
        this.sub_id = sub_id;
        this.car = car;
        this.cha_height = cha_height;
        this.tyre = tyre;
        this.direction_sys = direction_sys;
        this.damper = damper;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public String getCha_height() {
        return cha_height;
    }

    public void setCha_height(String cha_height) {
        this.cha_height = cha_height;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public String getDirection_sys() {
        return direction_sys;
    }

    public void setDirection_sys(String direction_sys) {
        this.direction_sys = direction_sys;
    }

    public String getDamper() {
        return damper;
    }

    public void setDamper(String damper) {
        this.damper = damper;
    }

    @Override
    public String toString() {
        return "Suv{" +
                "sub_id=" + sub_id +
                ", car=" + car +
                ", cha_height='" + cha_height + '\'' +
                ", tyre='" + tyre + '\'' +
                ", direction_sys='" + direction_sys + '\'' +
                ", damper='" + damper + '\'' +
                '}';
    }
}
