package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Venta;

import java.util.List;

public interface I_VentaService {

    public void crearVenta(Venta venta);
    public void anularVenta(Long id);
    public void editarVenta(Long id, Venta venta);
    public List<Venta> traerListaVentas();
    public Venta traerVenta(Long id);
}
