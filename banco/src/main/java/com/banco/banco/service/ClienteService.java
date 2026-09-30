package com.banco.banco.service;

import com.banco.banco.model.Cliente;
import com.banco.banco.model.Empresa;
import com.banco.banco.model.PersonaFisica;
import com.banco.banco.model.Premium;
import com.banco.banco.repository.ClienteRepository;
import com.banco.banco.validation.CuitValidator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service = reglas de negocio.
 * Antes de guardar una empresa, validamos el CUIT.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final CuitValidator cuitValidator;

    public ClienteService(ClienteRepository clienteRepository, CuitValidator cuitValidator) {
        this.clienteRepository = clienteRepository;
        this.cuitValidator = cuitValidator;
    }

    public Empresa crearEmpresa(Empresa empresa) {
        // Primero validamos. Si está mal, no llega al save.
        cuitValidator.validarOFallar(empresa.getCuit());
        return (Empresa) clienteRepository.save(empresa);
    }

    public PersonaFisica crearPersonaFisica(PersonaFisica personaFisica) {
        return (PersonaFisica) clienteRepository.save(personaFisica);
    }

    public Premium crearPremium(Premium premium) {
        return (Premium) clienteRepository.save(premium);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public List<Empresa> listarEmpresas() {
        return clienteRepository.findAll().stream()
                .filter(Empresa.class::isInstance)
                .map(Empresa.class::cast)
                .toList();
    }

    public List<PersonaFisica> listarPersonasFisicas() {
        return clienteRepository.findAll().stream()
                .filter(PersonaFisica.class::isInstance)
                .map(PersonaFisica.class::cast)
                .toList();
    }

    public List<Premium> listarPremium() {
        return clienteRepository.findAll().stream()
                .filter(Premium.class::isInstance)
                .map(Premium.class::cast)
                .toList();
    }
}
