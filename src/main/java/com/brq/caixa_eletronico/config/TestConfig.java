package com.brq.caixa_eletronico.config;

import java.util.Arrays;

import com.brq.caixa_eletronico.modelo.Caixa;
import com.brq.caixa_eletronico.modelo.Cliente;
import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.modelo.Usuario;
import com.brq.caixa_eletronico.repositorios.CaixaRepository;
import com.brq.caixa_eletronico.repositorios.ClienteRepository;
import com.brq.caixa_eletronico.repositorios.ContaRepository;
import com.brq.caixa_eletronico.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
      
        Cliente cliente1 = new Cliente(null, "João Silva");
        Cliente cliente2 = new Cliente(null, "Maria Aparecida");

        Usuario usuario1 = new Usuario("123456", new BCryptPasswordEncoder().encode("1234"));
        Usuario usuario2 = new Usuario("654321", new BCryptPasswordEncoder().encode("1234"));

        Conta conta1 = new Conta(null, cliente1, "1111", "123456", 200.0, usuario1);
        Conta conta2 = new Conta(null, cliente2, "2222", "654321", 300.0, usuario2);

        Caixa caixa = new Caixa(null, 10, 10, 10, 10);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        contaRepository.saveAll(Arrays.asList(conta1, conta2));

        caixaRepository.save(caixa);


    }
    

}
