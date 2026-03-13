package cl.example.repository;

import cl.example.model.Transaccion;

import java.util.List;

public interface TransaccionRepository {

        Integer crearTransaccion(Integer clienteId, Double monto);
        void eliminarTransaccion(int idTransaccion);
        List<Transaccion> obtenerTransaccionesPorCliente(int clienteId);
}
