package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {

    @Test
    void carrinhoVazioDeveTerTotalZero() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 100.0);

        carrinho.adicionarProduto(teclado);

        assertEquals(100.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveSomarVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(new Produto("Teclado", 100.0));
        carrinho.adicionarProduto(new Produto("Mouse", 50.0));

        assertEquals(150.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveRemoverProduto() {
        Carrinho carrinho = new Carrinho();

        Produto teclado = new Produto("Teclado", 100.0);
        Produto mouse = new Produto("Mouse", 50.0);

        carrinho.adicionarProduto(teclado);
        carrinho.adicionarProduto(mouse);

        carrinho.removerProduto(mouse);

        assertEquals(100.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void naoDevePermitirPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Teclado", -100.0);
        });
    }

    @Test
    void naoDeveAplicarDescontoAbaixoDe500() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Produto", 499.99));

        assertEquals(499.99, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveAplicarDescontoEm500() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Produto", 500.00));

        assertEquals(450.00, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveAplicarDescontoAcimaDe500() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Produto", 500.01));

        assertEquals(450.009, carrinho.getTotal(), 0.001);
    }
}
