package com.brq.caixa_eletronico.servico.excecoes;

public class SaldoInsuficienteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException(){
        super("Não há saldo suficiente para realizar o saque.");
    }
    


}
