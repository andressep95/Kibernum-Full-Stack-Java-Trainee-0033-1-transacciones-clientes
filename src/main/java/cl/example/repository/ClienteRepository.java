package cl.example.repository;

import cl.example.model.Cliente;

import java.util.List;

public interface ClienteRepository {

    Integer crearCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int idCliente);
    Cliente obtenerCliente(int idCliente);
    List<Cliente> obtenerTodosLosClientes();
}
