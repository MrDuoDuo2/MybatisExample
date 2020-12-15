package com.github.mrduoduo2;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TimeServerHandler extends IoHandlerAdapter {
    public static final HappyLog HAPPY_LOG = new HappyLog(TimeServerHandler.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        MysqlController mysqlController = new MysqlController();
        mysqlController.init();

        String str = new String((byte[]) message, StandardCharsets.UTF_8);
        if (str.trim().equalsIgnoreCase("quit")) {
            sessionClosed(session);
            return;
        }

//        System.out.println(str);

        SqlJson json = JsonUtils.fromJson(str, SqlJson.class);

        String mess = null;
        if (json.METHOD.equals("INSERT")) {
            if (json.TABLE.equals("BUS")) {
                mess = mysqlController.insertBus();
            }
            if (json.TABLE.equals("SUV")) {
                mess = mysqlController.insertSuv();
            }
            if (json.TABLE.equals("ATTR")) {
                mess = mysqlController.insertAttr();
            }
            if (json.TABLE.equals("VEHICLE")) {
                mess = mysqlController.insertVehicle();
            }
        }
        if (json.METHOD.equals("SELECT")) {
            mess = mysqlController.findByColor("Red");
        }
        if (json.METHOD.equals("DELETE")) {
            mess = mysqlController.delete();
        }

        if (json.METHOD.equals("UPDATE")) {
            mess = mysqlController.update();
        }

        Date date = new Date();

//        System.out.println(mess);
        session.write(mess + "\n");
//        System.out.println(date.toString());
        System.out.println("Message written...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) {
        HAPPY_LOG.enterFunc("sessionIdle");
        System.out.println("IDLE " + session.getIdleCount(status));
        HAPPY_LOG.exitFunc("sessionIdle");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
    }

    public static class SqlJson {
        private String METHOD;
        private String TABLE;
    }
}

