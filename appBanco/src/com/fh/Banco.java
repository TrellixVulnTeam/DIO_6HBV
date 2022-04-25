package com.fh;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void listarContas(){
        System.out.println("*********** Lista de Clientes(Contas) ************");
        System.out.println("Banco: " + getNome());
        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.cliente.getNome());
            System.out.println("Número " + conta.getNumero());
            System.out.println( String.format("Saldo %.2f", conta.getSaldo()));
        }
    }


}
