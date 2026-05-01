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
}