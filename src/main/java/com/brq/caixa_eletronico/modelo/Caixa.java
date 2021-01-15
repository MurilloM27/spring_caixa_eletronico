package com.brq.caixa_eletronico.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_caixa_eletronico")
public class Caixa {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer notasCem;
    private Integer notasCinq;
    private Integer notasVinte;
    private Integer notasDez;

    public Caixa(){}

    public Caixa(Long id, Integer notasCem, Integer notasCinq, Integer notasVinte, Integer notasDez) {
        this.id = id;
        this.notasCem = notasCem;
        this.notasCinq = notasCinq;
        this.notasVinte = notasVinte;
        this.notasDez = notasDez;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNotasCem() {
        return this.notasCem;
    }

    public void setNotasCem(Integer notasCem) {
        this.notasCem = notasCem;
    }

    public Integer getNotasCinq() {
        return this.notasCinq;
    }

    public void setNotasCinq(Integer notasCinq) {
        this.notasCinq = notasCinq;
    }

    public Integer getNotasVinte() {
        return this.notasVinte;
    }

    public void setNotasVinte(Integer notasVinte) {
        this.notasVinte = notasVinte;
    }

    public Integer getNotasDez() {
        return this.notasDez;
    }

    public void setNotasDez(Integer notasDez) {
        this.notasDez = notasDez;
    }

    public Integer acrescentarNotaCem(Integer notas){
        return notasCem += notas;
    }

    public Integer acrescentarNotaCinq(Integer notas){
        return notasCinq += notas;
    }

    public Integer acrescentarNotaVinte(Integer notas){
        return notasVinte += notas;
    }

    public Integer acrescentarNotaDez(Integer notas){
        return notasDez += notas;
    }

    public Integer sacarNotaCem(Integer quantidade){
        return notasCem -= quantidade;
    }

    public Integer sacarNotaCinq(Integer quantidade){
        return notasCinq -= quantidade;
    }

    public Integer sacarNotaVinte(Integer quantidade){
        return notasVinte -= quantidade;
    }

    public Integer sacarNotaDez(Integer quantidade){
        return notasDez -= quantidade;
    }

}
