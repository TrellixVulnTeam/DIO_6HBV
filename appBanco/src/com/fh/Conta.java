package com.fh;

import java.util.Objects;

public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;
    private static int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
       saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
       saldo += valor;
    }

    @Override
    public void tranferir(double valor, Conta contaDestino) {
       this.sacar(valor);
       contaDestino.depositar(valor);
    }

    public void imprimirInfoComum() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Número: " + getNumero());
        System.out.println( String.format("Saldo %.2f", getSaldo()));
    }

}
