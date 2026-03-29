package com.luis.javapos.modulo2.collections.aula02_cli.service;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CardapioService {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> obterProdutos() { return produtos; }

    public boolean adicionarProduto(String nomeProduto, double precoProduto, Categoria categoria) {

        if (nomeProduto != null && precoProduto > 0 && categoria != null) {
            Produto produto = new Produto(nomeProduto, precoProduto, categoria);
            produtos.add(produto);
        } else {
            return false;
        }
        return true;
    }
}