package com.luis.javapos.modulo2.collections.aula02_cli;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;
import com.luis.javapos.modulo2.collections.aula02_cli.service.CardapioService;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

// TODO: Melhoria de if opcao -> switch.

public class MenuCLI {

    public static void imprimirLista(List<Produto> lista, String titulo) {

        if (lista.isEmpty()) {
            System.out.println("Nenhum produto encontrado!");
        } else {
            System.out.println("\n--- " + titulo + "---");

            for (Produto produto : lista) {
                System.out.println(produto);
            }

            System.out.println("-------------------------\n");
        }
    }

    public static void run() {

        Scanner scanner = new Scanner(System.in);
        CardapioService service = new CardapioService();

        while (true) {
            System.out.println("1 - Listar");
            System.out.println("2 - Adicionar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Filtrar");
            System.out.println("5 - Ordenar");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Encerrando o sistema..."); return; }

            if (opcao == 1) {

                List<Produto> produtos = service.obterProdutos();

                if (produtos.isEmpty()) {
                    System.out.println("Nenhum Produto Cadastrado!");
                } else {
                    System.out.println("\n--- CARDÁPIO ---");

                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }

                    System.out.println("---------------\n");
                }
            }

            if (opcao == 2) {

                System.out.println("Qual o nome do produto?");
                String nomeProduto = scanner.nextLine();

                System.out.println("Qual o preço do produto?");
                double precoProduto = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Qual a categoria do produto? (LANCHE, BEBIDA, SOBREMESA)");
                String strCategoria = scanner.nextLine();
                Categoria categoria = Categoria.valueOf(strCategoria.toUpperCase());

                boolean resultado = service.adicionarProduto(nomeProduto , precoProduto, categoria);

                if (resultado) {
                    System.out.println("O produto " + nomeProduto + " foi adicionado!");
                } else {
                    System.out.println("O produto " + nomeProduto + " não foi adicionado!");
                }
            }

            if (opcao == 3) {
                System.out.println("Qual produto deseja buscar?");
                String produtoBusca = scanner.nextLine();

                List<Produto> resultado = service.buscarPorNome(produtoBusca);

                MenuCLI.imprimirLista(resultado, "RESULTADO DA BUSCA");
            }

            if (opcao == 4) {
                System.out.println("Qual categoria deseja buscar?");
                String strCategoriaBusca = scanner.nextLine();

                Categoria categoria = Categoria.valueOf(strCategoriaBusca.toUpperCase());
                List<Produto> resultado = service.filtrarPorCategoria(categoria);

                MenuCLI.imprimirLista(resultado, "PRODUTOS DA CATEGORIA");
            }

            if (opcao == 5) {
                List<Produto> listaOrdenada = service.ordenarPorPreco();

                MenuCLI.imprimirLista(listaOrdenada, "PRODUTOS ORDENADOS");
            }
        }
    }
}
