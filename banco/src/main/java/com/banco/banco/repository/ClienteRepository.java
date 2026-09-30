package com.banco.banco.repository;

import com.banco.banco.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos.
 * Spring Data JPA genera la implementación en runtime:
 * save, findAll, findById, deleteById, etc. sin escribir SQL.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
