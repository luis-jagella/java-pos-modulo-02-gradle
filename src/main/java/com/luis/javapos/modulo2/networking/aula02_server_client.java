package com.luis.javapos.modulo2.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class aula02_server_client {

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server - OK | Door - 8000");

            while (true) {
                Socket client = server.accept();

                new Thread(() -> {
                    try {
                        System.out.println("Client: " + client.getInetAddress() + " connect!");

                        InputStream input = client.getInputStream();

                        byte[] buffer = new byte[1024];
                        int bytesLidos = input.read(buffer);

                        if (bytesLidos != -1) {
                            String request = new String(buffer, 0, bytesLidos);
                            System.out.println("Message received: " + request);
                        }

                        client.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}