package com.brq.caixa_eletronico.config;

import java.util.Arrays;

import com.brq.caixa_eletronico.modelo.Caixa;
import com.brq.caixa_eletronico.modelo.Cliente;
import com.brq.caixa_eletronico.modelo.Conta;
import com.brq.caixa_eletronico.repositorios.CaixaRepository;
import com.brq.caixa_eletronico.repositorios.ClienteRepository;
import com.brq.caixa_eletronico.repositorios.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CaixaRepository caixaRepository;

    @Override
    public void run(String... args) throws Exception {
      
        Cliente cliente1 = new Cliente(null, "João Silva");
        Cliente cliente2 = new Cliente(null, "Maria Aparecida");

        Conta conta1 = new Conta(null, cliente1, "1111", "123456", 200.0);
        Conta conta2 = new Conta(null, cliente2, "2222", "654321", 300.0);

        Caixa caixa = new Caixa(null, 100, 100, 100, 100);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        contaRepository.saveAll(Arrays.asList(conta1, conta2));

        caixaRepository.save(caixa);

    }
    

}
