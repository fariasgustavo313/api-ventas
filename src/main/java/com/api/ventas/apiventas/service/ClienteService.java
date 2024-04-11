package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Cliente;
import com.api.ventas.apiventas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements I_ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public void agregarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void editarcliente(Long id, Cliente cliente) {
        Cliente cli = this.traerCliente(id);
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
        cli.setDni(cliente.getDni());

        this.agregarCliente(cli);
    }

    @Override
    public List<Cliente> traerListaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente traerCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
