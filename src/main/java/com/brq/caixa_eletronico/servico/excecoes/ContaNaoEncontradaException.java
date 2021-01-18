package com.brq.caixa_eletronico.servico.excecoes;

public class ContaNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContaNaoEncontradaException(String agencia, String numeroConta){
        super("Conta com agencia: " + agencia + ", e número de conta: " + numeroConta + " não encontrada.");
    }
    

}
