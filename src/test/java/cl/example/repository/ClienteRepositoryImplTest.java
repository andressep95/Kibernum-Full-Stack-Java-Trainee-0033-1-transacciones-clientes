package cl.example.repository;

import cl.example.model.Cliente;
import cl.example.repository.implementation.ClienteRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteRepositoryImplTest {

    ClienteRepository clienteRepository = new ClienteRepositoryImpl();

    @Test
    void crearCliente() {
        Cliente cliente = new Cliente(null, "Juan Perez", "juan@correo.cl");

        Integer clienteId = clienteRepository.crearCliente(cliente);
        System.out.println("Cliente creado con ID: " + clienteId);
        assertNotNull(clienteId);
    }

    @Test
    void actualizarCliente() {
        Cliente cliente = new Cliente(null, "Maria Lopez", "maria@gmail.com");

        Integer clienteId = clienteRepository.crearCliente(cliente);
        assertNotNull(clienteId);

        cliente.setClienteId(clienteId);
        cliente.setNombre("Maria Lopez Actualizada");
        cliente.setEmail("maria.actualizada@gmail.com");

        clienteRepository.actualizarCliente(cliente);

    }

    @Test
    void obtenerClientePorId() {
        Cliente cliente = clienteRepository.obtenerCliente(1);

        assertNotNull(cliente);
        assertEquals("Juan Perez", cliente.getNombre());
    }

    @Test
    void eliminarCliente() {
        clienteRepository.eliminarCliente(3);

    }
}