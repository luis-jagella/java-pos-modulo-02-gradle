package com.luis.javapos.modulo2.collections.aula02_cli;

import com.luis.javapos.modulo2.collections.aula02_cli.model.Categoria;
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

            if (opcao == 1) {
                for (Produto produto : service.obterProdutos()) {

                    if (produto != null) {
                        System.out.println(produto);
                    } else {
                        System.out.println("Nenhum Produto Cadastrado!");
                    }
                }
            }
            if (opcao == 2) {

                System.out.println("Qual o nome do produto?");
                String nomeProduto = scanner.nextLine();

                System.out.println("Qual o preço do produto?");
                double precoProduto = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Qual a categoria do produto? (LANCHE, BEBIDA, SOBREMESA)");
                // TODO: Ver sobre como manipular Enum nesses casos.
                //String categoriaEntrada = scanner.nextLine();
                //String   = categoriaEntrada.toUpperCase();
                //Categoria categoria = scanner.nextLine();

                boolean resultado = service.adicionarProduto(nomeProduto , precoProduto, categoria);

                if (resultado) {
                    System.out.println("O produto " + nomeProduto + " foi adicionado!");
                } else {
                    System.out.println("O produto " + nomeProduto + " não foi adicionado!");
                }
            }

            if (opcao == 0) { return; }
        }
    }
}
