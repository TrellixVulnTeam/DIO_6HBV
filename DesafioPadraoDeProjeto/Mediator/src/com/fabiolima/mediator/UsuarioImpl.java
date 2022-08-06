package com.fabiolima.mediator;

public class UsuarioImpl extends  Usuario{

    public UsuarioImpl(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }

    @Override
    public void enviar(String msn) {
        System.out.println( this.nome + " Enviando msn " + msn);
    }

    @Override
    public void receber(String msn) {
        System.out.println(this.nome + " Recebendo msn " + msn);
    }
}
