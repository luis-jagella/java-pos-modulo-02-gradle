package com.luis.javapos.modulo2.collections.aula02_cli.service;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CardapioService {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> listarProdutos() { return produtos; }

    public void adicionarProduto(String nomeProduto, double precoProduto, Categoria categoria) {
        Produto produto = new Produto(nomeProduto, precoProduto, categoria);
        produtos.add(produto);
    }
}