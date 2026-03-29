package com.luis.javapos.modulo2.collections.aula02_cli;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Produto;
import com.luis.javapos.modulo2.collections.aula02_cli.service.CardapioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCLI {

    public static void run() {

        Scanner scanner = new Scanner(System.in);
        CardapioService service = new CardapioService();

        while (true) {
            System.out.println("1 - Listar");
            System.out.println("2 - Adicionar");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) { service.listarProdutos()) }
            if (opcao == 2) {

                System.out.println("Qual o nome do produto?");
                String nomeProduto = scanner.nextLine();

                System.out.println("Qual o preço do produto?");
                double precoProduto = scanner.nextDouble();

                service.adicionarProduto(nomeProduto , precoProduto);

                System.out.println("O produto" + nomeProduto + ", custando: " + precoProduto + "foi adicionado!");
            }

            if (opcao == 0) { return; }

        }
    }
}
