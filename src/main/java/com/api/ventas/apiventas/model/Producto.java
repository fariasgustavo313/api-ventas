package com.api.ventas.apiventas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Long id_producto;
    private String nombre;
    private String marca;
    private double costo;
    private Long cantidad;
    private Long stock_disponible;
}
