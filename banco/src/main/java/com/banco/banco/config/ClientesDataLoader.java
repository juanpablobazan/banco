package com.banco.banco.config;

import com.banco.banco.model.Empresa;
import com.banco.banco.model.PersonaFisica;
import com.banco.banco.model.Premium;
import com.banco.banco.repository.ClienteRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Component
public class ClientesDataLoader implements ApplicationRunner {

    private final ClienteRepository clienteRepository;
    private final ObjectMapper objectMapper;

    public ClientesDataLoader(ClienteRepository clienteRepository, ObjectMapper objectMapper) {
        this.clienteRepository = clienteRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws IOException {
        if (clienteRepository.count() > 0) {
            return;
        }

        ClientesIniciales clientes = objectMapper.readValue(
                new ClassPathResource("clientes.json").getInputStream(),
                ClientesIniciales.class
        );

        clienteRepository.saveAll(clientes.empresas());
        clienteRepository.saveAll(clientes.personasFisicas());
        clienteRepository.saveAll(clientes.premium());
    }

    private record ClientesIniciales(
            List<Empresa> empresas,
            List<PersonaFisica> personasFisicas,
            List<Premium> premium
    ) {
    }
}
