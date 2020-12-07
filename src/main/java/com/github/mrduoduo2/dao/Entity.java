package com.github.mrduoduo2.dao;

import com.github.mrduoduo2.models.*;

import java.util.List;

public interface Entity {
    //select
    Bus selectBus(int id);
    int countVehicle();
    int countBus();
    int countBus2();
    Vehicle findByColor(String color);
    Vehicle findBus();
    Vehicleview selectView();

    //insert
    void insertSuv(Suv suv);
    void insertBus(Bus bus);
    void insertAttr(Attr attr);
    void insertVehicle(Vehicle vehicle);

    //update
    void updateBus();


    //delete
    void deleteBus(int sub_id);

}
