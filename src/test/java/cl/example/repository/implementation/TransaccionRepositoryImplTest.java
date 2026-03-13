package cl.example.repository.implementation;

import cl.example.model.Cliente;
import cl.example.model.Transaccion;
import cl.example.repository.ClienteRepository;
import cl.example.repository.TransaccionRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionRepositoryImplTest {

    ClienteRepository clienteRepository = new ClienteRepositoryImpl();
    TransaccionRepository transaccionRepository = new TransaccionRepositoryImpl();


    @Test
    void crearTransaccion() {
        Cliente cliente = new Cliente(null, "Carlos Sanchez", "carlos@gmail.com");
        Integer clienteId = clienteRepository.crearCliente(cliente);
        System.out.println("Cliente creado con ID: " + clienteId);

        Integer transaccionId = transaccionRepository.crearTransaccion(clienteId, 150.75);
        System.out.println("Transacción creada con ID: " + transaccionId);

        assertNotNull(transaccionId);
    }

    @Test
    void listarTransaccionesPorCliente() {
        List<Transaccion> transacciones = transaccionRepository.obtenerTransaccionesPorCliente(5);

        for (Transaccion t : transacciones) {
            System.out.println("Transacción ID: " + t.getTransaccionId() + ", Monto: " + t.getMonto() + ", Fecha: " + t.getFecha());
        }

        assertNotNull(transacciones);

    }

    @Test
    void eliminarTransaccion() {
        transaccionRepository.eliminarTransaccion(1);
    }
}