package cl.example.repository;

import cl.example.model.Cliente;

public interface ClienteRepository {

    void crearCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    Integer obtenerClientePorId(int idCliente);
    SELECT COUNT(*) FROM clientes WHERE id_cliente = ?;

    void eliminarCliente(int idCliente);
    Cliente obtenerCliente(int idCliente);
}
