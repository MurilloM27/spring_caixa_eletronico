package com.brq.caixa_eletronico.servico;

import java.util.List;

import com.brq.caixa_eletronico.modelo.Caixa;
import com.brq.caixa_eletronico.repositorios.CaixaRepository;
import com.brq.caixa_eletronico.servico.excecoes.LimiteNotasCaixaException;
import com.brq.caixa_eletronico.servico.excecoes.ValorInvalidoException;

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

    public void acrescentarNotaCaixa(Integer tipoNota, Integer quantidade){
        List<Caixa> filtro = repository.findAll();
        Caixa caixa = filtro.get(0);

        if(tipoNota == 100){
            if(caixa.getNotasCem() + quantidade > 100){
                throw new LimiteNotasCaixaException();
            } else {
                caixa.acrescentarNotaCem(quantidade);
            }
        } else if(tipoNota == 50){
            if(caixa.getNotasCinq() + quantidade > 100){
                throw new LimiteNotasCaixaException();
            } else {
                caixa.acrescentarNotaCinq(quantidade);
            }
        } else if(tipoNota == 20){
            if(caixa.getNotasVinte() + quantidade > 100){
                throw new LimiteNotasCaixaException();
            } else {
                caixa.acrescentarNotaVinte(quantidade);
            }
        } else if(tipoNota == 10){
            if(caixa.getNotasDez() + quantidade > 100){
                throw new LimiteNotasCaixaException();
            } else {
                caixa.acrescentarNotaDez(quantidade);
            }
        } else {
            throw new ValorInvalidoException();
        }

        repository.save(caixa);
    }
}
