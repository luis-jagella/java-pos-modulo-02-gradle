package com.luis.javapos.modulo2.collections.aula02_cli.service;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;

import java.util.ArrayList;
import java.util.Comparator;
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

    public List<Produto> buscarPorNome(String produtoBusca) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(produtoBusca))
                .toList();
    }

    public List<Produto> filtrarPorCategoria(Categoria categoriaBusca) {
        return produtos.stream()
                . filter(p -> p.getCategoria() == categoriaBusca)
                .toList();
    }

    public List<Produto> ordenarPorPreco() {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();
    }
}