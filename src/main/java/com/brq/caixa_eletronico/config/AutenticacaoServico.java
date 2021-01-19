package com.brq.caixa_eletronico.config;

import java.util.Optional;

import com.brq.caixa_eletronico.modelo.Usuario;
import com.brq.caixa_eletronico.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoServico implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByUsername(username);
        if(usuario.isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Não encontrada!");
    }
    
}
