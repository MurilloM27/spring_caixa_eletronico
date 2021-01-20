package com.brq.caixa_eletronico.config;

// import java.util.Arrays;
import java.util.Optional;

// import com.brq.caixa_eletronico.modelo.Caixa;
// import com.brq.caixa_eletronico.modelo.Cliente;
import com.brq.caixa_eletronico.modelo.Conta;
// import com.brq.caixa_eletronico.modelo.PerfilAcesso;
import com.brq.caixa_eletronico.modelo.Usuario;
// import com.brq.caixa_eletronico.repositorios.CaixaRepository;
// import com.brq.caixa_eletronico.repositorios.ClienteRepository;
import com.brq.caixa_eletronico.repositorios.ContaRepository;
// import com.brq.caixa_eletronico.repositorios.PerfilAcessoRepository;
import com.brq.caixa_eletronico.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // @Autowired
    // private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    // @Autowired
    // private CaixaRepository caixaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @Autowired
    // private PerfilAcessoRepository perfilRepository;

    @Override
    public void run(String... args) throws Exception {
      
        // Cliente cliente1 = new Cliente(null, "João Silva");
        // Cliente cliente2 = new Cliente(null, "Maria Aparecida");

        // Usuario usuario1 = new Usuario("123456", new BCryptPasswordEncoder().encode("1234"));
        // Usuario usuario2 = new Usuario("654321", new BCryptPasswordEncoder().encode("1234"));

        // Conta conta1 = new Conta(null, cliente1, "1111", "123456", 200.0, usuario1);
        // Conta conta2 = new Conta(null, cliente2, "2222", "654321", 300.0, usuario2);

        // Caixa caixa = new Caixa(null, 10, 10, 10, 10);

        // PerfilAcesso perfilAcesso1 = new PerfilAcesso(null, "ROLE_CLIENTE");
        // PerfilAcesso perfilAcesso2 = new PerfilAcesso(null, "ROLE_ADM");

        // clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        // usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        // contaRepository.saveAll(Arrays.asList(conta1, conta2));

        // caixaRepository.save(caixa);

        // perfilRepository.saveAll(Arrays.asList(perfilAcesso1, perfilAcesso2));

        Optional<Usuario> filtroUser1 = usuarioRepository.findByUsername("123456");
        Usuario usuario1 = filtroUser1.get();

        Optional<Usuario> filtroUser2 = usuarioRepository.findByUsername("654321");
        Usuario usuario2 = filtroUser2.get();

        Optional<Conta> filtro1 = contaRepository.findById(1L);
        Conta conta1 = filtro1.get();
        conta1.setUser(usuario1);
        contaRepository.save(conta1);

        Optional<Conta> filtro2 = contaRepository.findById(2L);
        Conta conta2 = filtro2.get();
        conta2.setUser(usuario2);
        contaRepository.save(conta2);
        


    }
    

}
