package com.github.mrduoduo2.models;

public class Vehicleview {
    private String plate;
    private int vehicle_id;
    private int sub_id;

    public Vehicleview() {
    }

    public Vehicleview(String plate, int vehicle_id, int sub_id) {
        this.plate = plate;
        this.vehicle_id = vehicle_id;
        this.sub_id = sub_id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    @Override
    public String toString() {
        return "VehicleView{" +
                "plate='" + plate + '\'' +
                ", vehicle_id=" + vehicle_id +
                ", sub_id=" + sub_id +
                '}';
    }
}
