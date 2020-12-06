package com.github.mrduoduo2;

import com.github.mrduoduo2.dao.Entity;
import com.github.mrduoduo2.models.Bus;
import com.github.mrduoduo2.models.Vehicle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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
            Vehicle vehicle =entity.findByPlate();

            int vehicleID = vehicle.getVehicle_id();
            int TypeID = vehicle.getType_id();

            System.out.println(vehicleID);
            System.out.println(TypeID);



        }

    }
}
