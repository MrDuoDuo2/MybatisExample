package com.github.mrduoduo2;

import com.github.mrduoduo2.dao.Entity;
import com.github.mrduoduo2.models.Bus;
import com.github.mrduoduo2.models.Vehicle;
import com.github.mrduoduo2.models.Vehicleview;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
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
        String json = JsonUtils.toUpperCaseJson(vehicleMap);
        return json;
    }


    public String sql(JsonElement method, JsonElement field, JsonElement table, JsonElement where) {

        switch (method.toString()){
            case "SELECT" :
                break;
            case "INSERT" :
                break;
            case "UPDATE" :
                break;
            case "DELETE" :
                break;
        }



        return "";
    }
}
