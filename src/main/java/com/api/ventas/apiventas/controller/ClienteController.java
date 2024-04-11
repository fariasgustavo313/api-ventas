package com.api.ventas.apiventas.controller;

import com.api.ventas.apiventas.model.Cliente;
import com.api.ventas.apiventas.service.I_ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private I_ClienteService interCliente;

    @PostMapping
    public void agregarCliente(@RequestBody Cliente cliente) {
        interCliente.agregarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarcliente(@PathVariable Long id) {
        interCliente.eliminarCliente(id);
    }

    @PutMapping("/{id}")
    public void editarCliente(@PathVariable Long id,
                              @RequestBody Cliente cliente) {
        interCliente.editarcliente(id, cliente);
    }

    @GetMapping
    public List<Cliente> traerListaClientes() {
        return interCliente.traerListaClientes();
    }

    @GetMapping("/{id}")
    public Cliente traerCliente(@PathVariable Long id) {
        return interCliente.traerCliente(id);
    }
}
