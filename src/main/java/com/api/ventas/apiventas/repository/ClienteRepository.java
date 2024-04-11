package com.api.ventas.apiventas.repository;

import com.api.ventas.apiventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.dni = :dni")
    public Cliente traerClientePorDni(String dni);
}
