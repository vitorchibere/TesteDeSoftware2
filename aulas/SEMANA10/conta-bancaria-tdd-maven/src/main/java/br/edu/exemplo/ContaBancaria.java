package br.edu.exemplo;

public class ContaBancaria {

    private double saldo = 0.0;

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}