package com.brq.caixa_eletronico.servico;

import com.brq.caixa_eletronico.modelo.Caixa;
import com.brq.caixa_eletronico.modelo.Conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoServico {

    @Autowired
    private CaixaServico caixaServico;

    @Autowired
    private ContaServico contaServico;

    // Tem que pegar pelo ID, e selecionar o cliente
    public void sacarQuantia(Long id, Double valor){
        
        Conta conta = contaServico.findContaById(id);

        if(valor <= conta.getSaldo()& valor > 0) {       
            conta.sacar(valor);
		} else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar a operação;");
        }
    }

    // Pegar pelo ID
    public void depositar(Long id, Double valor){
        
        Conta conta = contaServico.findContaById(id);

        if(valor > 0){
           conta.deposita(valor);
        } else {
            throw new IllegalArgumentException("Valor inválido, tente novamente");
        }
    }

    public String quantidadeNotas(Double valor){

        int notasCem = 0;
        int notasCinq = 0;
        int notasVinte = 0;
        int notasDez = 0;

        Caixa caixa = caixaServico.findCaixa();

        if(valor > 0){

            if (valor % 10 == 0) {

                while (valor >= 100) {
                    valor -= 100;
                    notasCem++;
                    caixa.sacarNotaCem(notasCem);
                }
    
                while (valor >= 50) {
                    valor -= 50;
                    notasCinq++;
                    caixa.sacarNotaCinq(notasCinq);                    
                }
    
                while (valor >= 20) {
                    valor -= 20;
                    notasVinte++;
                    caixa.sacarNotaVinte(notasVinte);
                }
    
                while (valor >= 10) {
                    valor -= 10;
                    notasDez++;
                    caixa.sacarNotaDez(notasDez);
                }
            } else {
                throw new IllegalArgumentException("Valor inválido, tente novamente.");
            }
        }

        caixaServico.atualizarCaixa(caixa);
        
        return  "Notas de 100: " + Integer.toString(notasCem) 
        + " Notas de 50: " + Integer.toString(notasCinq) 
        + " Notas de 20: " + Integer.toString(notasVinte)
        + " Notas de 10: " + Integer.toString(notasDez);

    }

}
