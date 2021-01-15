package com.brq.caixa_eletronico.controller;

import java.util.List;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.repositorios.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @Autowired
    private ContaRepository contaRepository;

    @GetMapping(value = "/home")
    public String home(Model model){
        List<Conta> contas = contaRepository.findAll();
        model.addAttribute("contas", contas);
        return "home";
    }
}
