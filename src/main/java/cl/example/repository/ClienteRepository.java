package cl.example.repository;

import cl.example.model.Cliente;

public interface ClienteRepository {

    Integer crearCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int idCliente);
    Cliente obtenerCliente(int idCliente);
}
