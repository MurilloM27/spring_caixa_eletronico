package com.brq.caixa_eletronico.controller.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.brq.caixa_eletronico.servico.excecoes.ContaNaoEncontradaException;
import com.brq.caixa_eletronico.servico.excecoes.LimiteNotasCaixaException;
import com.brq.caixa_eletronico.servico.excecoes.NotasIndisponiveisException;
import com.brq.caixa_eletronico.servico.excecoes.SaldoInsuficienteException;
import com.brq.caixa_eletronico.servico.excecoes.ValorInvalidoException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ContaNaoEncontradaException.class)
    public String contaNaoEncontrada(ContaNaoEncontradaException e, HttpServletRequest request, Model model){
        String erro = "Conta não encontrada, verifique os dados e tente novamente.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status, erro, e.getMessage(), request.getRequestURI());
        model.addAttribute("erro", erroPadrao);
        return "tratamentoErros/contaNaoEncontrada";
    }

    @ExceptionHandler(ValorInvalidoException.class)
    public String valorInvalido(ValorInvalidoException e, HttpServletRequest request, Model model){
        String erro = "O valor digitado é inválido, tente novamente";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status, erro, e.getMessage(), request.getRequestURI());
        model.addAttribute("erro", erroPadrao);
        return "tratamentoErros/valorInvalido";
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public String saldoInsuficiente(SaldoInsuficienteException e, HttpServletRequest request, Model model){
        String erro = "Não há saldo suficiente para a realização do saque.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status, erro, e.getMessage(), request.getRequestURI());
        model.addAttribute("erro", erroPadrao);
        return "tratamentoErros/saldoInsuficiente";
    }

    @ExceptionHandler(NotasIndisponiveisException.class)
    public String valorInsuficienteParaSaque(NotasIndisponiveisException e, HttpServletRequest request, Model model){
        String erro = "Não há notas suficientes para realizar o saque do valor desejado, tente novamente mais tarde.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status, erro, e.getMessage(), request.getRequestURI());
        model.addAttribute("erro", erroPadrao);
        return "tratamentoErros/notasInsuficientes";
    }

    @ExceptionHandler(LimiteNotasCaixaException.class)
    public String limiteNotasCaixa(LimiteNotasCaixaException e, HttpServletRequest request, Model model){
        String erro = "O limite de notas no caixa foi ultrapassado, não é possível realizar a operação.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status, erro, e.getMessage(), request.getRequestURI());
        model.addAttribute("erro", erroPadrao);
        return "tratamentoErros/limiteCaixa";
    }

}
