package com.brq.caixa_eletronico.controller;

import com.brq.caixa_eletronico.servico.CaixaServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notas")
public class NotasController {
    
    @Autowired
    private CaixaServico caixaServico;

    @GetMapping
    public String notas(){
        return "notas";
    }

    @PostMapping("/resultadoNotas")
    public String acrescentarNotasCaixa(Integer tipoNota, Integer quantidade){
        caixaServico.acrescentarNotaCaixa(tipoNota, quantidade);
        return "resultadoNotas";
    }
}
