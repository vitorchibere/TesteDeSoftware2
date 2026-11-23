package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double getTotal() {
        double subtotal = 0.0;

        for (Produto produto : produtos) {
            subtotal += produto.getPreco();
        }

        if (subtotal >= 500.0) {
            return subtotal * 0.90;
        }

        return subtotal;
    }
}