package com.brq.caixa_eletronico.servico;

import java.util.List;
import java.util.Optional;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.repositorios.ContaRepository;
import com.brq.caixa_eletronico.servico.excecoes.ContaNaoEncontradaException;

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

	public void saveConta(Conta conta) {
        repository.save(conta);
    }
    
    public Conta findByAgenciaENumeroConta(String agencia, String numeroConta){
       Conta conta = repository.findByAgenciaAndNumeroConta(agencia, numeroConta);
       if(conta == null){
           throw new ContaNaoEncontradaException(agencia, numeroConta);
       } 
       return conta;
    }

    public Conta findByUsuario(String username){
        Conta conta = repository.findByUser(username);
        if(conta == null){
            throw new NullPointerException();
        }
        return conta;
    }
}
