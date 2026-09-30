package com.banco.banco.controller;

import com.banco.banco.model.Empresa;
import com.banco.banco.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Capa web: recibe HTTP y responde JSON.
 * No valida reglas de negocio: eso lo hace el Service.
 */
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final ClienteService clienteService;

    public EmpresaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Empresa> crear(@RequestBody Empresa empresa) {
        Empresa creada = clienteService.crearEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping
    public List<Empresa> listar() {
        return clienteService.listarEmpresas();
    }
}
