package com.luis.javapos.modulo2;

import java.util.List;

public class Cardapio {
    private List<Produto> produtos;

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
