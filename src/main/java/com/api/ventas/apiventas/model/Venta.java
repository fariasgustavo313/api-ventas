package com.api.ventas.apiventas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    private LocalDate fecha_venta;
    private double total;
    @ManyToMany
    @JoinTable(name = "venta_lista_productos",
                joinColumns = @JoinColumn(name = "id_venta"),
                inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Producto> lista_productos;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
