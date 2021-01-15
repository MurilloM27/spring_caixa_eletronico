package com.brq.caixa_eletronico.repositorios;

import com.brq.caixa_eletronico.modelo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
