package com.github.mrduoduo2;

import com.github.mrduoduo2.dao.Entity;
import com.github.mrduoduo2.models.Attr;
import com.github.mrduoduo2.models.Bus;
import com.github.mrduoduo2.models.Suv;
import com.github.mrduoduo2.models.Vehicle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MysqlController {
    public InputStream inputStream;
    public SqlSession session;
    private Entity entity;
    public void init() throws IOException {

        inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        entity = session.getMapper(Entity.class);
    }

    public String findByColor(String color){
        Vehicle vehicle = entity.findByColor(color);
        Map<String,Object> vehicleMap = new HashMap<>();
        vehicleMap.put("车辆ID",vehicle.getVehicle_id());
        vehicleMap.put("公用属性ID",vehicle.getAttr().getAttr_id());
        return JsonUtils.toUpperCaseJson(vehicleMap);
    }


    public String insertBus(){
        Bus bus =new Bus();
        bus.setLine("788");
        bus.setFloor(2);
        bus.setCar(2);
        bus.setMonitor(30);
        bus.setSub_id(3);

        entity.insertBus(bus);
        session.commit();
        return "OK";
    }

    public String insertSuv(){
        Suv suv = new Suv();
        suv.setCar(2);
        suv.setSub_id(3);
        suv.setCha_height("");

        entity.insertSuv(suv);
        session.commit();
        return "OK";
    }

    public String insertAttr(){
        Attr attr = new Attr();
        attr.setAttr_id(2);
        attr.setColor("Blue");
        attr.setSpeed(110);
        attr.setDoor(4);
        attr.setWindows(20);

        entity.insertAttr(attr);
        session.commit();
        return "OK";
    }

    public String insertVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setType_id(1);
        vehicle.setAttr_id(2);
        vehicle.setSub_id(3);

        entity.insertVehicle(vehicle);
        session.commit();
        return "OK";
    }

    public String delete(){
        entity.deleteBus(2);
        session.commit();
        return "OK";
    }

    public String update(){
        entity.updateBus();
        session.commit();
        return "OK";
    }

}
