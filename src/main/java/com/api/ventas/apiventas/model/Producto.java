package com.api.ventas.apiventas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String marca;
    private double costo;
    private Long cantidad;
    private Long stock_disponible;
    @OneToMany(mappedBy = "lista_productos")
    private List<Venta> lista_ventas;
}
