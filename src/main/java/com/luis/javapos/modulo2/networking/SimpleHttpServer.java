package com.luis.javapos.modulo2.networking;

import java.io.*;
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

            int contentLenght = 0;

            while (!(line = reader.readLine()).isEmpty()) {
                if (line.startsWith("Content-Lenght")) {
                    contentLenght = Integer.parseInt(line.split(":")[1].trim());
                }
            }

            char[] bodyChars = new char[contentLenght];

            int totalRead=0
            while (totalRead < contentLenght) {
                int read = reader.read(bodyChars, totalRead, contentLenght - totalRead);
                if (read == -1) break;
                totalRead += read;
            }

            String body = new String(bodyChars);
            System.out.println("Body " + body);

            String response = "OK";

            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Content-Length: " + response.length() + "\r\n");
            writer.write("\r\n");
            writer.write(response);
            writer.flush();

        } catch (Exception e) {
            System.out.println("Erro client: " + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}