package com.fabiolima.catalogo.controller;

import com.fabiolima.catalogo.model.Produto;
import com.fabiolima.catalogo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

   @Autowired
   private ProdutoService produtoService;


   @GetMapping
   public List<Produto> listar(){
       return produtoService.listar();
   }

   @GetMapping("/{id}")
   public ResponseEntity buscarPorid(@PathVariable Long id){
       Produto produto = produtoService.buscarPorId(id);
       return ResponseEntity.ok(produto);
   }

   @PostMapping
   public ResponseEntity salvar(@RequestBody Produto produto){
       Produto produtoSalvo = produtoService.salvar(produto);
       return ResponseEntity.ok(produtoSalvo);
   }

    @DeleteMapping({"/{id}"})
    public void remover(@PathVariable Long id){
        produtoService.excluir(id);
        ResponseEntity.status(HttpStatus.NO_CONTENT);
    }

}
