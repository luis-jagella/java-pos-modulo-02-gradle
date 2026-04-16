package com.luis.javapos.modulo2.networking;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class aula01_socket {

    public static void main(String[] args) {

        // Praça da Sé
        String cep = "01001000";
        String urlParaChamada = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            conexao.setRequestMethod("GET");

            BufferedReader leitor = new StringBuilder();

        } catch (Exception e) {
            //exception
        }
    }
}