package com.fh;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Banco bb = new Banco();
        bb.setNome("Banco do Brasil");

        List<Conta> contas = new ArrayList<>();


        Cliente cliente = new Cliente();
        cliente.setNome("Fábio Lima");

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        cc.depositar(100.89);
        cc.depositar(50.78);
        cc.tranferir(40, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        contas.add(cc);
        contas.add(cp);

        bb.setContas(contas);
        bb.listarContas();

    }
}
