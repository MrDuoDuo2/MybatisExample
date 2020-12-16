package com.github.mrduoduo2;

import com.github.mrduoduo2.models.SqlJson;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

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

        SqlJson json = (SqlJson) message;

        SqlJson result = new SqlJson();
        result.setCODE(0);
        try {
            if (json.getMETHOD().equals("INSERT")) {
                switch (json.getTABLE()) {
                    case "BUS":
                        result.setMESSAGE(mysqlController.insertBus());
                        break;
                    case "SUV":
                        result.setMESSAGE(mysqlController.insertSuv());
                        break;
                    case "ATTR":
                        result.setMESSAGE(mysqlController.insertAttr());
                        break;
                    case "VEHICLE":
                        result.setMESSAGE(mysqlController.insertVehicle());
                        break;
                    case "":
                        result.setMESSAGE("表名为空");
                        break;
                }
            }
            if (json.getMETHOD().equals("SELECT")) {
                result.setDATA(mysqlController.findByColor("Red"));
            }
            if (json.getMETHOD().equals("DELETE")) {
                result.setMESSAGE(mysqlController.delete());
            }

            if (json.getMETHOD().equals("UPDATE")) {
                try {
                    result.setMESSAGE(mysqlController.update());
                } catch (Exception e) {
                    result.setMESSAGE("更新错误");
                }
            }

            if (json.getMETHOD().equals("")) {
                result.setMESSAGE("方法名为空");
            }
        }catch (Exception e){
            result.setMESSAGE("JSON不正确");
        }


        Date date = new Date();
        session.write( result);
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
}

