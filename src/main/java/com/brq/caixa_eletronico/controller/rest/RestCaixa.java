package com.brq.caixa_eletronico.controller.rest;

import java.util.List;
import java.util.Optional;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.repositorios.ContaRepository;
import com.brq.caixa_eletronico.servico.TransacaoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class RestCaixa {
    
    @Autowired
    private ContaRepository repository;

    @Autowired
    private TransacaoServico transacaoServico;

    @GetMapping
    public ResponseEntity<List<Conta>> listarAll(){
        List<Conta> contas = repository.findAll();
        return ResponseEntity.ok().body(contas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> listarPorId(@PathVariable Long id){
        Optional<Conta> conta = repository.findById(id);
        return ResponseEntity.ok().body(conta.get());
    }

    @PostMapping(value = "/deposito/{id}/{valor}")
    public ResponseEntity<Conta> deposito(@PathVariable Long id, @PathVariable Double valor){
        Optional<Conta> filtro = repository.findById(id);
        Conta conta = filtro.get();
        transacaoServico.depositar(conta.getId(), valor);
        repository.save(conta);
        return ResponseEntity.ok().body(conta);
    }

    @PostMapping(value = "/saque/{id}/{valor}")
    public ResponseEntity<String> saque(@PathVariable Long id, @PathVariable Double valor){
        Optional<Conta> filtro = repository.findById(id);
        Conta conta = filtro.get();
        transacaoServico.sacarQuantia(conta.getId(), valor);
        repository.save(conta);
        return ResponseEntity.ok().body(transacaoServico.quantidadeNotas(valor));
    }

}
