package com.luis.javapos.modulo2.networking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class aula02_server_client {

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server - OK | Door - 8000");

            while (true) {
                Socket client = server.accept();

                //new Thread(() -> handleClient(client)).start();
                new Thread(() -> {
                    try {
                        System.out.println("Client: " + client.getInetAddress() + " connect!");

                        InputStream input = client.getInputStream();
                        OutputStream output = client.getOutputStream();

                        byte[] buffer = new byte[1024];
                        int bytesLidos = input.read(buffer);

                        String request = "";
                        if (bytesLidos != -1) {
                            request = new String(buffer, 0, bytesLidos, StandardCharsets.UTF_8);
                            System.out.println("Message received: " + request);
                        }

                        String response = "Server received: " + request;
                        output.write(response.getBytes(StandardCharsets.UTF_8));
                        output.flush();

                        client.close();

                    } catch (Exception e) {
                        System.out.println("Error | Server: " + e.getMessage());
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }

    //private static void handleClient(Socket client) {}
}