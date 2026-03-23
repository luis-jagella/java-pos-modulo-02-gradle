package com.luis.javapos.modulo2;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("Pão com Frango", new BigDecimal("18.50")),
                new Produto("Hot Dog Paulista", new BigDecimal("20.60")),
                new Produto("Brownie", new BigDecimal("28.00"))
        );

        Cardapio cardapio = new Cardapio(produtos);

        Gson gson = new Gson();
        String json = gson.toJson(produtos);

        System.out.println(json);
    }
}
