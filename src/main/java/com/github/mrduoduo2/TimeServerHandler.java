package com.github.mrduoduo2;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

public class TimeServerHandler extends IoHandlerAdapter {
    public static final HappyLog HAPPY_LOG = new HappyLog(TimeServerHandler.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause ) {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception
    {
        HAPPY_LOG.enterFunc("messageReceived");

        System.out.println("messageReceived");
        MysqlController mysqlController = new MysqlController();
        mysqlController.init();

        String str = message.toString();
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close();
            return;
        }

        SqlJson sqlJson = JsonUtils.fromJson(str, SqlJson.class);

        String json = null;
        assert sqlJson != null;
        if (sqlJson.METHOD.equals("SELECT")){
            json = mysqlController.findByColor("Red");
        }
        if(sqlJson.METHOD.equals("INSERT") && sqlJson.TABLE.equals("BUS")){
            mysqlController.insertBus();
        }
        if(sqlJson.METHOD.equals("INSERT") && sqlJson.TABLE.equals("ATTR")){
            mysqlController.insertAttr();
        }
        if(sqlJson.METHOD.equals("INSERT") && sqlJson.TABLE.equals("VEHICLE")){
            mysqlController.insertVehicle();
        }
        if(sqlJson.METHOD.equals("INSERT") && sqlJson.TABLE.equals("SUV")){
            mysqlController.insertSuv();
        }
        if (sqlJson.METHOD.equals("UPDATE")){
            mysqlController.update();
        }
        if (sqlJson.METHOD.equals("DELETE")){
            mysqlController.delete();
        }

        Date date = new Date();
        System.out.println(json);
        session.write(json);

        System.out.println(date.toString());
        System.out.println("Message written...");

        HAPPY_LOG.exitFunc("messageReceived");
    }

    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) {
        HAPPY_LOG.enterFunc("sessionIdle");
        System.out.println( "IDLE " + session.getIdleCount( status ));
        HAPPY_LOG.exitFunc("sessionIdle");
    }

    public static class SqlJson{
        private String METHOD;
        private String TABLE;
    }
}

