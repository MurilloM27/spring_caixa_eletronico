package com.brq.caixa_eletronico.servico.excecoes;

public class NotasIndisponiveisException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotasIndisponiveisException(){
        super("Não há notas suficientes para realizar o saque do valor desejado.");
    }
    
}
