package com.github.mrduoduo2.models;

public class Vehicle {
    private int vehicle_id;
    private int type_id;
    private int sub_id;
    private int attr_id;
    Attr attr;

    public Vehicle() {
    }

    public Vehicle(int vehicle_id, int type_id, int sub_id, int attr_id) {
        this.vehicle_id = vehicle_id;
        this.type_id = type_id;
        this.sub_id = sub_id;
        this.attr_id = attr_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public int getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", type_id=" + type_id +
                ", sub_id=" + sub_id +
                ", attr_id=" + attr_id +
                ", attr=" + attr +
                '}';
    }
}
