package com.brq.caixa_eletronico.controller;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.servico.ContaServico;
import com.brq.caixa_eletronico.servico.TransacaoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("caixa")
public class CaixaController {
    
    @Autowired
    private TransacaoServico transacao;

    @Autowired
    private ContaServico contaServico;

    @GetMapping("/saque")
    public String saque(){
        return "saque";
    }

    @PostMapping("/resultadoSaque")
    public String realizarSaque(String agencia, String numeroConta, Double valor, Model model){
        Conta conta = contaServico.findByAgenciaENumeroConta(agencia, numeroConta);
        transacao.sacarQuantia(conta.getId(), valor);
        model.addAttribute("saldo", conta.getSaldo());
        model.addAttribute("notas", transacao.retornarNotas(valor));
        return "resultadoSaque";
    }

    @GetMapping("/deposito")
    public String deposito(){
        return "deposito";
    }
    
    @PostMapping("/resultadoDeposito")
    public String realizarDeposito(String agencia, String numeroConta, Double valor, Model model){
        Conta conta = contaServico.findByAgenciaENumeroConta(agencia, numeroConta);
        transacao.depositar(conta.getId(), valor);
        model.addAttribute("saldo", conta.getSaldo());
        return "resultadoDeposito";
    }

}
