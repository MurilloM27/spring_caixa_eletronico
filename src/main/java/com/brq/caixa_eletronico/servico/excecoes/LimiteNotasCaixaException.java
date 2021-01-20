package com.brq.caixa_eletronico.servico.excecoes;

public class LimiteNotasCaixaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LimiteNotasCaixaException(){
        super("O limite de notas no caixa foi ultrapassado, não é possível acrescentar mais notas");
    }
    
}
