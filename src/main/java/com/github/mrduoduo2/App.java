package com.github.mrduoduo2;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Integer PORT = 9001;
        MinaTimeServer minaTimeServer = new MinaTimeServer();
        minaTimeServer.Bind(PORT);
    }
}
