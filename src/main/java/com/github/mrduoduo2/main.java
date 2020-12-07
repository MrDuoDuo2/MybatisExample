package com.github.mrduoduo2;

import com.github.mrduoduo2.dao.Entity;
import com.github.mrduoduo2.models.Bus;
import com.github.mrduoduo2.models.Vehicle;
import com.github.mrduoduo2.models.Vehicleview;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main {

    public void addVehicle(){

    }

    public static void main(String[] args) {
        String resource = "config.xml";
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        {
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Entity entity = session.getMapper(Entity.class);
            Vehicleview vehicleview = entity.selectView();
            Vehicle vehicle = entity.findByColor("Red");

            List<Vehicle> vehicleList = null;
            Vehicle vehicle1 = entity.selectVehicleIn(vehicleList);
//            System.out.println(vehicleview.toString());
            System.out.println(vehicle1.toString());
            session.commit();
        }

    }
}
