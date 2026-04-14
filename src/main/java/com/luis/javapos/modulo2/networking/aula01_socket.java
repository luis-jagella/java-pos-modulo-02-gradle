package com.luis.javapos.modulo2.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class aula01_socket {

    public static void main(String[] args) {

        //String cep = "01001000";
        //String urlParaChamada = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlParaChamada))
                    .build();

            System.out.println("Conectando ao ViaCEP...");
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResposta = response.body();
            System.out.println("JSON Bruto recebido: " + jsonResposta);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Object enderecoObjeto = gson.fromJson(jsonResposta, Object.class);

            System.out.println("\n--- Teste de Conversão Gson ---");
            System.out.println(gson.toJson(enderecoObjeto));
            System.out.println("Status da conexão: " + response.statusCode());

        } catch (Exception e) {
            System.out.println("Erro ao tentar conectar ou converter: " + e.getMessage());
            e.printStackTrace();
        }
    }
}