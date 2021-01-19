package com.brq.caixa_eletronico.repositorios;

import java.util.Optional;

import com.brq.caixa_eletronico.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByUsername(String username);
}
