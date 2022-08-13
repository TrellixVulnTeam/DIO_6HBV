package com.fabiolima.catalogo.service;

import com.fabiolima.catalogo.exception.ProdutoNullException;
import com.fabiolima.catalogo.model.Produto;
import com.fabiolima.catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        if(produto.getNome() == null || produto.getDescricao() == null) {
            throw new ProdutoNullException();
        }
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }

}
