package com.wl.padroesprojetospring.service;

import com.wl.padroesprojetospring.model.Cliente;
import com.wl.padroesprojetospring.model.Endereco;
import com.wl.padroesprojetospring.repository.ClienteRepository;
import com.wl.padroesprojetospring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService  {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> clienteBuscado = clienteRepository.findById(id);
        if(clienteBuscado.isPresent()){
            return clienteBuscado.get();
        }
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBuscado = clienteRepository.findById(id);
        if(clienteBuscado.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
       clienteRepository.deleteById(id);
    }



    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet( () -> {
            Endereco novoEndereco = viaCepService.consultaCep(cep);
            enderecoRepository.save(novoEndereco);
            return  novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
