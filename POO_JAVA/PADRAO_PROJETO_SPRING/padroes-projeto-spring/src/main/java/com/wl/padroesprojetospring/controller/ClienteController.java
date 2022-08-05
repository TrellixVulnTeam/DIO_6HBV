package com.wl.padroesprojetospring.controller;

import com.wl.padroesprojetospring.model.Cliente;
import com.wl.padroesprojetospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity buscarCliente(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity salvarCleinte(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok().body("Cliente salvo com sucesso.");

    }

}
