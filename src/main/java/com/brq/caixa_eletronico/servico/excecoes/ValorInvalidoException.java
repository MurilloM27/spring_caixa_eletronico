package com.brq.caixa_eletronico.servico.excecoes;

public class ValorInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValorInvalidoException(){
        super("Valor inválido para realizar operação, tente novamente.");
    }
    

}
