package com.luis.javapos.modulo2.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {

    private static final ConcurrentHashMap<Integer, String> banco = new ConcurrentHashMap<>();
    private static int counter = 0;

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);
        ExecutorService pool = Executors.newFixedThreadPool(10);

        System.out.println("HTTP Server rodando na porta 8080...");

        while (true) {
            Socket client = server.accept();

            pool.execute(() -> handle(client));
        }
    }

    private static void handle(Socket client) {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8)
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8)
                )
        ) {

            String line = reader.readLine();

            if (line == null) return;

            System.out.println("Request: " + line);

            if (line.startsWith("POST")) {

                while (!(line = reader.readLine()).isEmpty()) {}

                String body = reader.readLine();

                int id = ++counter;
                banco.put(id, body);

                String responseBody = "Saved: " + body;

                writer.write("HTTP/1.1 200 OK\r\n");
                writer.write("Content-Length: " + responseBody.length() + "\r\n");
                writer.write("\r\n");
                writer.write(responseBody);
                writer.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}