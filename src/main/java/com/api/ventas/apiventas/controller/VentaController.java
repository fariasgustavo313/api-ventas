package com.api.ventas.apiventas.controller;

import com.api.ventas.apiventas.dto.VentaDTO;
import com.api.ventas.apiventas.model.Producto;
import com.api.ventas.apiventas.model.Venta;
import com.api.ventas.apiventas.service.I_VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private I_VentaService interVenta;

    @PostMapping
    public void crearVenta(@RequestBody Venta venta) {
        interVenta.crearVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void anularVenta(@PathVariable Long id) {
        interVenta.anularVenta(id);
    }

    @PutMapping("/{id}")
    public void editarVenta(@PathVariable Long id,
                            @RequestBody Venta venta) {
        interVenta.editarVenta(id, venta);
    }

    @GetMapping
    public List<Venta> traerListaVentas() {
        return interVenta.traerListaVentas();
    }

    @GetMapping("/{id}")
    public Venta traerVenta(@PathVariable Long id) {
        return interVenta.traerVenta(id);
    }

    @GetMapping("/productos/{id}")
    public List<Producto> traerProductosPorVenta(@PathVariable Long id) {
        return interVenta.traerProductosPorVenta(id);
    }

    @GetMapping("/fecha")
    public String obtenerTotalVentasPorFecha(@RequestParam LocalDate fecha_venta) {
        return interVenta.obtenerTotalVentasPorFecha(fecha_venta);
    }

    @GetMapping("mayor_venta")
    public VentaDTO traerMayorVenta() {
        return interVenta.traerMayorVenta();
    }
}
