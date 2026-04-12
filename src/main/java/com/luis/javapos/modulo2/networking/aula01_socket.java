package com.luis.javapos.modulo2.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

 //Esqueleto de implementação para teste de comunicação com tratamento de erro para a primeira aula de networking da pós.

public class aula01_socket {

    public static void main(String[] args) {
        // 1. O CEP que vamos consultar
        String cep = "01001000";
        String urlParaChamada = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            // 2. Configuração do Cliente HTTP (o "socket" moderno do Java)
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlParaChamada))
                    .build();

            // 3. Enviando a requisição e recebendo a resposta como String
            System.out.println("Conectando ao ViaCEP...");
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Verificando o conteúdo bruto (o JSON que veio da rede)
            String jsonResposta = response.body();
            System.out.println("JSON Bruto recebido: " + jsonResposta);

            // 5. Utilizando o Gson para converter a String JSON num Objeto ou Map
            // Aqui usamos o GsonBuilder para formatar a saída (pretty printing)
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Vamos converter para um Object genérico apenas para validar o JSON
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