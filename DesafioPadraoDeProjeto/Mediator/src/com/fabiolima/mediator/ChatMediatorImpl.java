package com.fabiolima.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

    private List<Usuario> usuarios;

    public ChatMediatorImpl() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void enviarMsn(String msn, Usuario usuario) {
        for (Usuario u : this.usuarios){
            if(u != usuario){
                u.receber(msn);
            }
        }
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
