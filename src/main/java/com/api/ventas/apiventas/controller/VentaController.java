package com.api.ventas.apiventas.controller;

import com.api.ventas.apiventas.model.Venta;
import com.api.ventas.apiventas.service.I_VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
