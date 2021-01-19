package com.brq.caixa_eletronico.servico;

import java.util.List;

import com.brq.caixa_eletronico.modelo.Caixa;
import com.brq.caixa_eletronico.repositorios.CaixaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaixaServico {
    
    @Autowired
    private CaixaRepository repository;

    public Caixa findCaixa(){
        List<Caixa> filtro = repository.findAll();
        return filtro.get(0);
    }

    public void atualizarCaixa(Caixa caixa){
        repository.save(caixa);
    }

    public Double somatoriaValorCaixa(){
        List<Caixa> filtro = repository.findAll();
        Caixa caixa = filtro.get(0);

        double valorNoCaixa = (caixa.getNotasCem() * 100 + caixa.getNotasCinq() *50 + caixa.getNotasVinte() * 20 + caixa.getNotasDez() *10);
        
        return valorNoCaixa;
    }
}
