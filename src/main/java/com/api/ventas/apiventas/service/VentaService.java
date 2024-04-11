package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Cliente;
import com.api.ventas.apiventas.model.Producto;
import com.api.ventas.apiventas.model.Venta;
import com.api.ventas.apiventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements I_VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private I_ProductoService interProducto;
    @Autowired
    private I_ClienteService interCliente;

    @Override
    public void crearVenta(Venta venta) {
        List<Producto> productosAsociados = new ArrayList<>();
        Cliente cliente = venta.getCliente();
        Cliente clienteExistente = interCliente.traerCliente(cliente.getId_cliente());
        double subtotal = 0;
        Long stock = 0L;

        if (clienteExistente != null) {
            for (Producto producto : venta.getLista_productos()) {
                Producto productoExistente = interProducto.traerProductoPorNombre(producto.getNombre());
                if (productoExistente != null) {
                    if (productoExistente.getStock_disponible() >= producto.getCantidad()) {
                        productosAsociados.add(productoExistente);
                        subtotal += producto.getCantidad() * productoExistente.getCosto();
                        //stock = productoExistente.getStock_disponible() - producto.getCantidad();
                        //interProducto.actualizarStock(productoExistente.getId_producto(), stock);
                    } else {
                        System.out.println("El producto " + producto.getId_producto() + " no cuenta con stock suficiente");
                    }
                } else {
                    System.out.println("El producto " + producto.getId_producto() + " no existe en la base de datos");
                }
            }
        } else {
            System.out.println("Cliente inexistente");
        }


        venta.setFecha_venta(LocalDate.now());
        venta.setLista_productos(productosAsociados);
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
        for ( Producto producto : venta.getLista_productos()) {
            subtotal += producto.getCantidad() * producto.getCosto();
        }
        vta.setFecha_venta(LocalDate.now());
        vta.setCliente(venta.getCliente());
        vta.setLista_productos(venta.getLista_productos());
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
