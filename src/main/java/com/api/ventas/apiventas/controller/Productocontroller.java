package com.api.ventas.apiventas.controller;

import com.api.ventas.apiventas.model.Producto;
import com.api.ventas.apiventas.service.I_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class Productocontroller {

    @Autowired
    private I_ProductoService interProducto;

    @PostMapping
    public void agregarProducto(@RequestBody Producto producto) {
        interProducto.agregarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        interProducto.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public void editarProducto(@PathVariable Long id,
                               @RequestBody Producto producto) {
        interProducto.editarProducto(id, producto);
    }

    @GetMapping
    public List<Producto> traerListaProductos() {
        return interProducto.traerListaProductos();
    }

    @GetMapping("/{id}")
    public Producto traerProducto(@PathVariable Long id) {
        return interProducto.traerProducto(id);
    }
}
