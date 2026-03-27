package com.luis.javapos.modulo2.collections.aula01_overview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    }
}
