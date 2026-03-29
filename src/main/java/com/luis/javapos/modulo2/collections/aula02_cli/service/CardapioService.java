package com.luis.javapos.modulo2.collections.aula02_cli.service;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;

import java.util.ArrayList;
import java.util.List;

// TODO: Class com bug, mas acabei me perdendo no fonte ://

public class CardapioService {

    String nomeProduto;
    double precoProduto;
    Categoria categoria;

    public void setProduto(String nomeProduto, double precoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }}

    public static void listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.forEach(System.out::println);
    }

    public static void adicionarProduto(String nomeProduto, double precoProduto, Categoria categoria) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto = new Produto(nomeProduto, precoProduto, categoria);
        produtos.add(produto);
    }
}
