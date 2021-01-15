package com.brq.caixa_eletronico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("caixa")
public class CaixaController {
    
    @GetMapping("/saque")
    public String saque(){
        return "saque";
    }

    @GetMapping("/deposito")
    public String deposito(){
        return "deposito";
    }

}
