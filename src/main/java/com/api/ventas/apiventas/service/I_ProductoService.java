package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Producto;

import java.util.List;

public interface I_ProductoService {

    public void agregarProducto(Producto producto);
    public void eliminarProducto(Long id);
    public void editarProducto(Long id, Producto producto);
    public List<Producto> traerListaProductos();
    public Producto traerProducto(Long id);
    public Producto traerProductoPorNombre(String nombre);
    public List<Producto> listaProductosPocoStock(Long stock);
    public void actualizarStock(Long id, Long stockActual);
}
