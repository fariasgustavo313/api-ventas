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
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_venta;
    private double total;
    @OneToMany
    private List<Producto> lista_productos;
    @OneToOne
    private Cliente cliente;
}
