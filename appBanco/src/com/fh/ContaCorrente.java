package com.fh;

public class ContaCorrente extends Conta {

    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.chequeEspecial = 5000;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("*************** Extrato Conta Corrente ***************");
        imprimirInfoComum();
        System.out.println("Limite cheque especial: " + getChequeEspecial());
    }
}
