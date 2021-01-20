package com.brq.caixa_eletronico.transacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.servico.ContaServico;
import com.brq.caixa_eletronico.servico.TransacaoServico;
import com.brq.caixa_eletronico.servico.excecoes.NotasIndisponiveisException;
import com.brq.caixa_eletronico.servico.excecoes.SaldoInsuficienteException;
import com.brq.caixa_eletronico.servico.excecoes.ValorInvalidoException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacaoTest {

    @Autowired
    private TransacaoServico transacao;

    @Autowired
    private ContaServico contaServico;
    
    @Test
    public void realizaDepositoEComparaValor(){
        Conta conta = contaServico.findContaById(1L);
        
        assertEquals(300.0, transacao.depositar(conta.getId(), 100.0));
    }
    
    @Test
    public void valorInvalidoParaDeposito(){
        Conta conta = contaServico.findContaById(1L);
        
        try {
            transacao.depositar(conta.getId(), -100.0);
        } catch (ValorInvalidoException e) {
            
        }
    }
    
    @Test
    public void realizaSaqueEComparaValor(){
        Conta conta = contaServico.findContaById(1L);
        transacao.sacarQuantia(conta.getId(), 100.0);
        assertEquals(100.0, 100.0);
    }
    
    @Test
    public void realizaSaqueEVerificaValorInvalido(){
        Conta conta = contaServico.findContaById(1L);

        try {
            transacao.sacarQuantia(conta.getId(), -100.0);
        } catch (ValorInvalidoException e) {
        }
    }

    @Test
    public void verificaSaldoENaoRealizaSaque(){
        Conta conta = contaServico.findContaById(1L);

        try {
            transacao.sacarQuantia(conta.getId(), 300.0);
        } catch (SaldoInsuficienteException e) {
        }
    }

    @Test
    public void testaQuantidadeNotasCaixaEComparaComValorSaque(){
        try {
            transacao.verificaValorSaque(2000.0);
            
        } catch (NotasIndisponiveisException e) {
        }
    }
}
