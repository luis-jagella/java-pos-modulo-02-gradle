package com.luis.javapos.modulo2.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class aula01_socket {

    public static void main(String[] args) {

        String cep = "01001000";
        String urlParaChamada = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream())
            );

            String linha;
            StringBuilder resposta = new StringBuilder();

            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }

            leitor.close();

            System.out.println("Resposta da API:");
            System.out.println(resposta.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}