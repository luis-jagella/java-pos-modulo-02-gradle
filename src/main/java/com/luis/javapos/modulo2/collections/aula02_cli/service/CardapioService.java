package com.luis.javapos.modulo2.collections.aula02_cli.service;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;

import java.util.ArrayList;
import java.util.List;

/* TODO: Tinha problema de excesso de responsas nessa class, pois eu estava tentando
    misturar coisas da classe produto, sendo que eu somente precisava criar
     um novo "Produto" com oque eu estava recebendo por parâmetro. */

public class CardapioService {

    List<Produto> produtos = new ArrayList<>();

    public void setProduto(String nomeProduto, double precoProduto, Categoria categoria) {
        Produto produto = new Produto(nomeProduto, precoProduto, categoria);
    }

    public void listarProdutos() {
        produtos.forEach(System.out::println);
    }

    public void adicionarProduto(String nomeProduto, double precoProduto, Categoria categoria) {
        Produto produto = new Produto(nomeProduto, precoProduto, categoria);
        produtos.add(produto);
    }
}
