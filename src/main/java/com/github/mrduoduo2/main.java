package com.github.mrduoduo2;

import com.github.mrduoduo2.dao.Entity;
import com.github.mrduoduo2.models.Bus;
import com.github.mrduoduo2.models.Vehicle;
import com.github.mrduoduo2.models.Vehicleview;
import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        Integer PORT = 9000;
        MinaTimeServer minaTimeServer = new MinaTimeServer();
        minaTimeServer.Bind(PORT);
    }
}
