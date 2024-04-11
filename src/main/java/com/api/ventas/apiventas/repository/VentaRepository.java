package com.api.ventas.apiventas.repository;

import com.api.ventas.apiventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
