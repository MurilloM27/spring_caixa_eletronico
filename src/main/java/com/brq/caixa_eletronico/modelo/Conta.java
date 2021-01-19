package com.brq.caixa_eletronico.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta {
 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
    private String numeroConta;
    private Double saldo;
    
    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Usuario user;
  
    public Conta(){}

    public Conta(Long id, Cliente cliente, String agencia, String numeroConta, Double saldo, Usuario usuario) {
        this.id = id;
        this.cliente = cliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.user = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public Double getSaldo() {
        return this.saldo;
    }

    public void deposita(Double valor){
        this.saldo += valor;
    }

    public Double sacar(Double valor){
        return this.saldo -= valor;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }



}
