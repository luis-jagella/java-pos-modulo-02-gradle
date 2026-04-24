package com.luis.javapos.modulo2.collections.aula01_overview;

import java.util.*;

public class CollectionsOverview {

    // TODO: Ainda falta implementar o seguinte método, a fim de utilizarmos o conceito de DRY.
    private static <T> void imprimirColecao(String titulo, Collection<T> colecao) {
        System.out.println("\n" + titulo);
        colecao.forEach(System.out::println);
    }

    public static void run() {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("X-tudo com ovo", 25, Categoria.LANCHE));
        produtos.add(new Produto("X-tudo com frango", 25, Categoria.LANCHE));
        produtos.add(new Produto("X-tudo com carne", 25, Categoria.LANCHE));

        System.out.println("LIST: ");
        produtos.forEach(System.out::println);

        Set<String> nomesProdutos = new HashSet<>();
        nomesProdutos.add("Pizza de 4 queijos");
        nomesProdutos.add("Pizza de calabresa");

        System.out.println("\nSET:");
        nomesProdutos.forEach(System.out::println);

        Set<String> nomesOrdenados = new TreeSet<>();
        nomesOrdenados.add("Z");
        nomesOrdenados.add("A");

        System.out.println("\nTREESET: ");
        nomesOrdenados.forEach(System.out::println);

        Map<String, Produto> produtosPorId = new HashMap<>();
        produtosPorId.put("1", new Produto("Monster branco", 8, Categoria.BEBIDA));

        System.out.println("\nMAP:");
        produtosPorId.forEach((k , v) -> System.out.println(k + " -> " + v));

        List<String> filaPedidos =  new LinkedList<>();
        filaPedidos.add("Pedido 01");
        filaPedidos.add("Pedido 02");
        filaPedidos.add("Pedido 02");

        System.out.println("\nLINKEDLIST:");
        filaPedidos.forEach(System.out::println);
    }
}
