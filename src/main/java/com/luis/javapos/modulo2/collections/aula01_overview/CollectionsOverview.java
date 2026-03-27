package com.luis.javapos.modulo2.collections.aula01_overview;

import java.util.*;

public class CollectionsOverview {

    public static void run() {

        // ♦ List (Permite duplicatas)
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("X-tudão", 25, Categoria.LANCHE));
        lista.add(new Produto("X-tudão", 25, Categoria.LANCHE));

        System.out.println("LIST: ");
        lista.forEach(System.out::println);

        // ♦ Set (Remove as duplicatas)
        Set<String> nomes = new HashSet<>();
        nomes.add("Pizza da italiana");
        nomes.add("Pizza da italiana");

        System.out.println("\nSET:");
        nomes.forEach(System.out::println);

        // ♦ TreeSet (Ordenado)
        Set<String> ordenado = new TreeSet<>();
        ordenado.add("Z");
        ordenado.add("A");

        System.out.println("\nTREESET: ");
        ordenado.forEach(System.out::println);

        // ♦ Map (chave/valor)
        Map<String, Produto> mapa = new HashMap<>();
        mapa.put("1", new Produto("Monster branco", 8, Categoria.BEBIDA));

        System.out.println("\nMAP:");
        mapa.forEach((k , v) -> System.out.println(k + " -> " + v));

        // ♦ LinkedList
        List<String> fila =  new LinkedList<>();
        fila.add("Pedido 01");
        fila.add("Pedido 02");

        System.out.println("\nLINKEDLIST:");
        fila.forEach(System.out::println);
    }
}
