package com.luis.javapos.modulo2.collections.aula02_cli.service;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void buscarPorNome(String produtoBusca) {
        List<Produto> filtrados = produtos.stream()
                . filter(p -> p.getNome().equals(produtoBusca))
                .toList();

        System.out.println(filtrados);
    }

    public void filtrarPorCategoria(Categoria categoriaBusca) {
        List<Produto> categoriaFiltrada = produtos.stream()
                . filter(p -> p.getCategoria() == categoriaBusca)
                .toList();

        if (categoriaFiltrada.isEmpty()) {
            System.out.println("Nenhum Produto");
        } else {
            System.out.println("--- Produto em " + categoriaBusca + "---");
            categoriaFiltrada.forEach(System.out::println);
        }

        System.out.println(categoriaFiltrada);
    }

    public void ordenarPorPreco() {
        List<Produto> ordenados = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();

        ordenados.forEach(System.out::println);
    }
}