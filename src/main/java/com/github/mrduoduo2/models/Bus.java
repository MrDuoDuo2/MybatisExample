package com.github.mrduoduo2.models;

public class Bus {
    private int sub_id;
    private int armrest;
    private String toll;
    private int monitor;
    private String line;
    private int floor;
    private int car;

    public Bus() {
    }

    public Bus(int sub_id, int armrest, String toll, int monitor, String line, int floor, int car) {
        this.sub_id = sub_id;
        this.armrest = armrest;
        this.toll = toll;
        this.monitor = monitor;
        this.line = line;
        this.floor = floor;
        this.car = car;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public int getArmrest() {
        return armrest;
    }

    public void setArmrest(int armrest) {
        this.armrest = armrest;
    }

    public String getToll() {
        return toll;
    }

    public void setToll(String toll) {
        this.toll = toll;
    }

    public int getMonitor() {
        return monitor;
    }

    public void setMonitor(int monitor) {
        this.monitor = monitor;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "sub_id=" + sub_id +
                ", armrest=" + armrest +
                ", toll='" + toll + '\'' +
                ", monitor=" + monitor +
                ", line='" + line + '\'' +
                ", floor=" + floor +
                ", car=" + car +
                '}';
    }
}
