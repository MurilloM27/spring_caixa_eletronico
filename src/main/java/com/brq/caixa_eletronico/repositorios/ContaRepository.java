package com.brq.caixa_eletronico.repositorios;

import com.brq.caixa_eletronico.modelo.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    
    Conta findByAgenciaAndNumeroConta(String agencia, String numeroConta);
}
