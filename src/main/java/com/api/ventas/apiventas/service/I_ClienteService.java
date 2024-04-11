package com.api.ventas.apiventas.service;

import com.api.ventas.apiventas.model.Cliente;

import java.util.List;

public interface I_ClienteService {

    public void agregarCliente(Cliente cliente);
    public void eliminarCliente(Long id);
    public void editarcliente(Long id, Cliente cliente);
    public List<Cliente> traerListaClientes();
    public Cliente traerCliente(Long id);
    public Cliente traerClientePorDni(String dni);
}
