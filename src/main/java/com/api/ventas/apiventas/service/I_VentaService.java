package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.dto.VentaDTO;
import com.api.ventas.apiventas.model.Producto;
import com.api.ventas.apiventas.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface I_VentaService {

    public void crearVenta(Venta venta);
    public void anularVenta(Long id);
    public void editarVenta(Long id, Venta venta);
    public List<Venta> traerListaVentas();
    public Venta traerVenta(Long id);
    public List<Producto> traerProductosPorVenta(Long id);
    public String obtenerTotalVentasPorFecha(LocalDate fecha_venta);
    public VentaDTO traerMayorVenta();
}
