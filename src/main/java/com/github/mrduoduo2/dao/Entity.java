package com.github.mrduoduo2.dao;

import com.github.mrduoduo2.models.Bus;
import com.github.mrduoduo2.models.Vehicle;

import java.util.List;

public interface Entity {
    int countVehicle();
    Bus selectBus(int id);


    void addSuv(int car,String cha_height,String tyre,String direction_sys,String damper);
    void addBus(int armrest,String toll,int monitor,String line,int floor,int car);
    void addAttr(int door,int windows,int lights,int wheel,String dyn_sys,String exh_sys,String clutch,String color,String fuel,String plate,int member);
    void addVehicle(int type_id,int sub_id,int attr_id);
    Vehicle findByPlate();


}
