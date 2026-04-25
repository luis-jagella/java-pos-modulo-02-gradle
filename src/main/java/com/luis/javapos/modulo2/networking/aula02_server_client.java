package com.luis.javapos.modulo2.networking;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class aula02_server_client {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Servidor - OK | Porta - 8000");

            while (true) {

                Socket client = server.accept();
                System.out.println("Cliente: " + client.getInetAddress() + "conectado!");

                InputStream input = client.getInputStream();

                byte[] buffer = new byte[1024];
                int bytesLidos = input.read(buffer);

                if (bytesLidos != -1) {
                    String request = new String(buffer, 0, bytesLidos);
                    System.out.println("Mensagem recebida: " + request);
                }

                client.close();
            }

        } catch (Exception e) {
            System.out.println("Erro no server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}