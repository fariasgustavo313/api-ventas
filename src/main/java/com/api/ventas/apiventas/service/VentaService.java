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
        String dni_cliente = venta.getCliente().getDni();
        Cliente clienteExistente = interCliente.traerClientePorDni(dni_cliente);
        double subtotal = 0;

        if (clienteExistente != null) {
            venta.setCliente(clienteExistente);
            venta.setFecha_venta(LocalDate.now());

            for (Producto producto : venta.getLista_productos()) {
                Producto productoExistente = interProducto.traerProductoPorNombre(producto.getNombre());

                if (productoExistente != null && productoExistente.getStock_disponible() >= producto.getCantidad()) {
                    productosAsociados.add(productoExistente);
                    subtotal += producto.getCantidad() * productoExistente.getCosto();
                    } else {
                        System.out.println("El producto " + producto.getId_producto() + " no cuenta con stock suficiente");
                }
            }

            venta.setLista_productos(productosAsociados);
            venta.setTotal(subtotal);
            ventaRepository.save(venta);

        } else {
            System.out.println("Cliente inexistente");
        }
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

    @Override
    public List<Producto> traerProductosPorVenta(Long id) {
        Venta vta = this.traerVenta(id);
        List<Producto> listaProductos = vta.getLista_productos();
        return listaProductos;
    }

    @Override
    public String obtenerTotalVentasPorFecha(LocalDate fecha_venta) {
        List<Venta> listaVentas = this.traerListaVentas();
        int contadorVentas = 0;
        double subtotal = 0;
        for (Venta vta : listaVentas) {
            if (vta.getFecha_venta().equals(fecha_venta)) {
                contadorVentas++;
                subtotal += vta.getTotal();
            }
            System.out.println("Distinto formato de fechas");
        }
        return "Fecha: " + fecha_venta + ", Cantidad de ventas: " + contadorVentas + " total vendido: " + subtotal;
    }
}
