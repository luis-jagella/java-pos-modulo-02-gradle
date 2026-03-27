package com.luis.javapos.modulo2.collections.aula01_overview;

import java.util.ArrayList;
import java.util.List;

public class CollectionsOverview {

    public static void run() {

        // ♦ List (Permite duplicatas)
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("X-tudão", 25, Categoria.LANCHE));
        lista.add(new Produto("X-tudão", 25, Categoria.LANCHE));

        System.out.println("LIST: ");
        lista.forEach(System.out::println);
    }
}
