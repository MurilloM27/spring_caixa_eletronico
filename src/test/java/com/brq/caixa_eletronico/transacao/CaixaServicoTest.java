package com.brq.caixa_eletronico.transacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.brq.caixa_eletronico.servico.CaixaServico;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaixaServicoTest {
    
    @Autowired
    private CaixaServico caixaServico;

    @Test
    public void somaAsNotasNoCaixaEComparaValor(){
        assertEquals(1800.0, caixaServico.somatoriaValorCaixa());
    }
}
