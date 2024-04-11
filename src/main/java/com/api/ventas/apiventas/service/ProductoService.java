package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Producto;
import com.api.ventas.apiventas.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements I_ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public void agregarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editarProducto(Long id, Producto producto) {
        Producto prod = this.traerProducto(id);
        prod.setNombre(producto.getNombre());
        prod.setMarca(producto.getMarca());
        prod.setCosto(producto.getCosto());
        prod.setCantidad(producto.getCantidad());
        prod.setStock_disponible(producto.getStock_disponible());

        this.agregarProducto(prod);
    }

    @Override
    public List<Producto> traerListaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto traerProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
