package com.github.mrduoduo2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

public class TimeServerHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause ) throws Exception
    {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception
    {
        MysqlController mysqlController = new MysqlController();
        mysqlController.init();

        String str = message.toString();
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close();
            return;
        }

        String result = str.trim();
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        System.out.println(result);
        JsonElement METHOD = jsonObject.get("METHOD");
        JsonElement FIELD = jsonObject.get("FIELD");
        JsonElement TABLE = jsonObject.get("TABLE");
        JsonElement WHERE = jsonObject.get("WHERE");

        String string = mysqlController.sql(METHOD,FIELD,TABLE,WHERE);

        Date date = new Date();
        String json = mysqlController.findByColor("Red");
        System.out.println(json);
        session.write(json);

        System.out.println(date.toString());
        System.out.println("Message written...");
    }

    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception
    {
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {

    }
}
