package com.api.ventas.apiventas.repository;

import com.api.ventas.apiventas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
    public Producto traerProductoPorNombre(String nombre);
}
