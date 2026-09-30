package com.banco.banco.controller;

import com.banco.banco.model.Premium;
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
@RequestMapping("/api/premium")
public class PremiumController {

    private final ClienteService clienteService;

    public PremiumController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Premium> crear(@RequestBody Premium premium) {
        Premium creado = clienteService.crearPremium(premium);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public List<Premium> listar() {
        return clienteService.listarPremium();
    }
}
