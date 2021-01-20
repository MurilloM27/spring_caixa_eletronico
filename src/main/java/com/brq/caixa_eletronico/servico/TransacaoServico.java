package com.brq.caixa_eletronico.servico;

import com.brq.caixa_eletronico.modelo.Caixa;
import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.servico.excecoes.NotasIndisponiveisException;
import com.brq.caixa_eletronico.servico.excecoes.SaldoInsuficienteException;
import com.brq.caixa_eletronico.servico.excecoes.ValorInvalidoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoServico {

    @Autowired
    private CaixaServico caixaServico;

    @Autowired
    private ContaServico contaServico;

    // Tem que pegar pelo ID, e selecionar o cliente
    public String sacarQuantia(Long id, Double valor){
        
        Conta conta = contaServico.findContaById(id);

        if(valor < 0){
            throw new ValorInvalidoException();
        }

        int notasCem = 0;
        int notasCinq = 0;
        int notasVinte = 0;
        int notasDez = 0;

        Caixa caixa = caixaServico.findCaixa();

        verificaValorSaque(valor);

        if(valor <= conta.getSaldo()) { 
            
            conta.sacar(valor);

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
            } else{
                throw new ValorInvalidoException();
            }
        } else {
            throw new SaldoInsuficienteException();
        }

        contaServico.saveConta(conta);
        caixaServico.atualizarCaixa(caixa);

        return  "Seu novo saldo é de: " + conta.getSaldo() 
        + "\nNotas de 100: " + Integer.toString(notasCem) 
        + " Notas de 50: " + Integer.toString(notasCinq) 
        + " Notas de 20: " + Integer.toString(notasVinte)
        + " Notas de 10: " + Integer.toString(notasDez);
    }
		
    // Pegar pelo ID
    public String depositar(Long id, Double valor){
        
        Conta conta = contaServico.findContaById(id);

        if(valor > 0){
           conta.deposita(valor);
        } else {
            throw new ValorInvalidoException();
        }

        contaServico.saveConta(conta);

        return "Seu novo saldo é de: " + conta.getSaldo();
    }

    public String retornarNotas(Double valor){

        int notasCem = 0;
        int notasCinq = 0;
        int notasVinte = 0;
        int notasDez = 0;

        if(valor > 0){

            if (valor % 10 == 0) {

                while (valor >= 100) {
                    valor -= 100;
                    notasCem++;
                }
    
                while (valor >= 50) {
                    valor -= 50;
                    notasCinq++;                 
                }
    
                while (valor >= 20) {
                    valor -= 20;
                    notasVinte++;
                }
    
                while (valor >= 10) {
                    valor -= 10;
                    notasDez++;
                }
            }
        } else {
            throw new ValorInvalidoException();
        }

        return "[Notas de 100: " + Integer.toString(notasCem) + "], " 
        + " [Notas de 50: " + Integer.toString(notasCinq) + "], " 
        + " [Notas de 20: " + Integer.toString(notasVinte) + "], "
        + " [Notas de 10: " + Integer.toString(notasDez) + "]";
    }

    public boolean verificaValorSaque(Double valor){

        if(caixaServico.somatoriaValorCaixa() >= valor){
            return true;
        }
        throw new NotasIndisponiveisException();
    }

}
