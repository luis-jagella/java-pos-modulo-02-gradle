package com.luis.javapos.modulo2.collections.aula01_overview;

import java.util.*;

public class CollectionsOverview {

    public static void run() {

        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("X-tudo com ovo", 25, Categoria.LANCHE));
        lista.add(new Produto("X-tudo com frango", 25, Categoria.LANCHE));
        lista.add(new Produto("X-tudo com carne", 25, Categoria.LANCHE));

        System.out.println("LIST: ");
        lista.forEach(System.out::println);

        Set<String> nomes = new HashSet<>();
        nomes.add("Pizza de 4 queijos");
        nomes.add("Pizza de calabresa");

        System.out.println("\nSET:");
        nomes.forEach(System.out::println);

        Set<String> ordenado = new TreeSet<>();
        ordenado.add("Z");
        ordenado.add("A");

        System.out.println("\nTREESET: ");
        ordenado.forEach(System.out::println);

        Map<String, Produto> mapa = new HashMap<>();
        mapa.put("1", new Produto("Monster branco", 8, Categoria.BEBIDA));

        System.out.println("\nMAP:");
        mapa.forEach((k , v) -> System.out.println(k + " -> " + v));

        List<String> fila =  new LinkedList<>();
        fila.add("Pedido 01");
        fila.add("Pedido 02");
        fila.add("Pedido 02");

        System.out.println("\nLINKEDLIST:");
        fila.forEach(System.out::println);
    }
}
