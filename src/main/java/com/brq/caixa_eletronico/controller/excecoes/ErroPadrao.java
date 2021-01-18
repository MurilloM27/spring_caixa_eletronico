package com.brq.caixa_eletronico.controller.excecoes;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ErroPadrao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instant timeStamp;
    private HttpStatus status;
    private String erro;
    private String messagem;
    private String path;

    public ErroPadrao(){}

    public ErroPadrao(Instant timeStamp, HttpStatus status, String erro, String messagem, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.erro = erro;
        this.messagem = messagem;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMessagem() {
        return this.messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
}
