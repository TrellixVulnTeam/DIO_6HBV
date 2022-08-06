package com.fabiolima.mediator;

public abstract class Usuario {

    protected ChatMediator mediator;

    protected String nome;

    public Usuario(ChatMediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
    }

    public abstract void enviar(String msn);

    public abstract void receber(String msn);
}
