package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Producto;
import com.api.ventas.apiventas.model.Venta;
import com.api.ventas.apiventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements I_VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Override
    public void crearVenta(Venta venta) {
        double subtotal = 0;
        for (Producto producto : venta.getListaProductos()) {
            subtotal += producto.getCantidad() * producto.getCosto();
        }
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(subtotal);
        ventaRepository.save(venta);
    }

    @Override
    public void anularVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public void editarVenta(Long id, Venta venta) {
        Venta vta = this.traerVenta(id);
        double subtotal = 0;
        for ( Producto producto : venta.getListaProductos()) {
            subtotal += producto.getCantidad() * producto.getCosto();
        }
        vta.setFecha_venta(LocalDate.now());
        vta.setCliente(venta.getCliente());
        vta.setListaProductos(venta.getListaProductos());
        vta.setTotal(subtotal);

        this.crearVenta(vta);
    }

    @Override
    public List<Venta> traerListaVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta traerVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }
}
