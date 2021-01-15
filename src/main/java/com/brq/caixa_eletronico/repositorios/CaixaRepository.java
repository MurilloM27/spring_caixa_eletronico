package com.brq.caixa_eletronico.repositorios;

import com.brq.caixa_eletronico.modelo.Caixa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
    
}
