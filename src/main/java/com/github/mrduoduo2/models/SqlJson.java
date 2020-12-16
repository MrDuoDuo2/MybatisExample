package com.github.mrduoduo2.models;

public class SqlJson {
    String METHOD;
    String TABLE;
    Integer CODE;
    String MESSAGE;
    String DATA;

    public String getMETHOD() {
        return METHOD;
    }

    public void setMETHOD(String METHOD) {
        this.METHOD = METHOD;
    }

    public String getTABLE() {
        return TABLE;
    }

    public void setTABLE(String TABLE) {
        this.TABLE = TABLE;
    }

    public Integer getCODE() {
        return CODE;
    }

    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }
}
