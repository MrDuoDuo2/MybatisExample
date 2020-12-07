package com.github.mrduoduo2.models;

public class Attr {
    private Long attr_id;
    private int door;
    private int windows;
    private int lights;
    private int wheel;
    private String dyn_sys;
    private String exh_sys;
    private String clutch;
    private String color;
    private String fuel;
    private String plate;
    private int member;
    private int speed;

    public Attr() {
    }

    public Attr(Long attr_id, int door, int windows, int lights, int wheel, String dyn_sys, String exh_sys, String clutch, String color, String fuel, String plate, int member, int speed) {
        this.attr_id = attr_id;
        this.door = door;
        this.windows = windows;
        this.lights = lights;
        this.wheel = wheel;
        this.dyn_sys = dyn_sys;
        this.exh_sys = exh_sys;
        this.clutch = clutch;
        this.color = color;
        this.fuel = fuel;
        this.plate = plate;
        this.member = member;
        this.speed = speed;
    }

    public Long getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(Long attr_id) {
        this.attr_id = attr_id;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getLights() {
        return lights;
    }

    public void setLights(int lights) {
        this.lights = lights;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public String getDyn_sys() {
        return dyn_sys;
    }

    public void setDyn_sys(String dyn_sys) {
        this.dyn_sys = dyn_sys;
    }

    public String getExh_sys() {
        return exh_sys;
    }

    public void setExh_sys(String exh_sys) {
        this.exh_sys = exh_sys;
    }

    public String getClutch() {
        return clutch;
    }

    public void setClutch(String clutch) {
        this.clutch = clutch;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Attr{" +
                "attr_id=" + attr_id +
                ", door=" + door +
                ", windows=" + windows +
                ", lights=" + lights +
                ", wheel=" + wheel +
                ", dyn_sys='" + dyn_sys + '\'' +
                ", exh_sys='" + exh_sys + '\'' +
                ", clutch='" + clutch + '\'' +
                ", color='" + color + '\'' +
                ", fuel='" + fuel + '\'' +
                ", plate='" + plate + '\'' +
                ", member=" + member +
                ", speed=" + speed +
                '}';
    }
}
