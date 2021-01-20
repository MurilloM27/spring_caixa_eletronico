package com.brq.caixa_eletronico.controller.rest;

import java.util.List;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.servico.ContaServico;
import com.brq.caixa_eletronico.servico.TransacaoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contas")
public class ContasRestController {
    
    @Autowired
    private ContaServico contaServico;

    @Autowired
    private TransacaoServico transacaoServico;

    @GetMapping
    public ResponseEntity<List<Conta>> listarAll(){
        List<Conta> contas = contaServico.findAllContas();
        return ResponseEntity.ok().body(contas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> listarPorId(@PathVariable Long id){
        Conta conta = contaServico.findContaById(id);
        return ResponseEntity.ok().body(conta);
    }

    @PostMapping(value = "/deposito/{id}/{valor}")
    public ResponseEntity<String> deposito(@PathVariable Long id, @PathVariable Double valor){
        Conta conta = contaServico.findContaById(id);
        return ResponseEntity.ok().body(transacaoServico.depositar(conta.getId(), valor));
    }

    @PostMapping(value = "/saque/{id}/{valor}")
    public ResponseEntity<String> saque(@PathVariable Long id, @PathVariable Double valor){
        Conta conta = contaServico.findContaById(id);
        return ResponseEntity.ok().body(transacaoServico.sacarQuantia(conta.getId(), valor));
    }

}
