package com.banco.banco.controller;

import com.banco.banco.model.PersonaFisica;
import com.banco.banco.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personas-fisicas")
public class PersonaFisicaController {

    private final ClienteService clienteService;

    public PersonaFisicaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<PersonaFisica> crear(@RequestBody PersonaFisica personaFisica) {
        PersonaFisica creada = clienteService.crearPersonaFisica(personaFisica);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping
    public List<PersonaFisica> listar() {
        return clienteService.listarPersonasFisicas();
    }
}
