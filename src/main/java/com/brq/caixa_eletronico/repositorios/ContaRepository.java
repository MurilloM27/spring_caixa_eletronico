package com.brq.caixa_eletronico.repositorios;

import com.brq.caixa_eletronico.modelo.Conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    
    Conta findByAgenciaAndNumeroConta(String agencia, String numeroConta);

    @Query("Select c from Conta c join c.user u where u.username = :pUsername")
    Conta findByUser(@Param("pUsername") String username);

}
