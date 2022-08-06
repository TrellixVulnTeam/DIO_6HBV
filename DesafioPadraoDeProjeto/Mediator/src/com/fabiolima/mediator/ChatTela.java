package com.fabiolima.mediator;

public class ChatTela {

    public static void main(String[] args) {

        ChatMediator chatMediator = new ChatMediatorImpl();

        Usuario usuario1 = new UsuarioImpl(chatMediator, "Lima");
        Usuario usuario2 = new UsuarioImpl(chatMediator, "Rocha");

        chatMediator.adicionarUsuario(usuario1);
        chatMediator.adicionarUsuario(usuario2);

        usuario1.enviar("Olá pessoal");

    }

}
