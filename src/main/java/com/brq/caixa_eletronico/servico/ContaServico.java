package com.brq.caixa_eletronico.servico;

import java.util.List;
import java.util.Optional;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.repositorios.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaServico {
    
    @Autowired
    private ContaRepository repository;

    public List<Conta> findAllContas(){
        List<Conta> contas = repository.findAll();
        return contas;
    }

    public Conta findContaById(Long id){
        Optional<Conta> filtro = repository.findById(id);
        return filtro.get();
    }
}
