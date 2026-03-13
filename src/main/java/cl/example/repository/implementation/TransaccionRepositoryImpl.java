package cl.example.repository.implementation;

import cl.example.configuration.DatabaseConnection;
import cl.example.model.Transaccion;
import cl.example.repository.TransaccionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaccionRepositoryImpl implements TransaccionRepository {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public Integer crearTransaccion(Integer clienteId, Double monto) {
        String sql = "INSERT INTO transacciones (id_cliente, monto, fecha) VALUES (?, ?, NOW())";

        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)
            ) {

            preparedStatement.setInt(1, clienteId);
            preparedStatement.setDouble(2, monto);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminarTransaccion(int idTransaccion) {
        String query = "DELETE FROM transacciones WHERE id_transaccion = ?";
        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

            preparedStatement.setInt(1, idTransaccion);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaccion> obtenerTransaccionesPorCliente(int clienteId) {
        String sql = "SELECT * FROM transacciones WHERE id_cliente = ?";
        List<Transaccion> transacciones = new ArrayList<>();

        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ) {
            preparedStatement.setInt(1, clienteId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transaccion transaccion = new Transaccion(
                    resultSet.getInt("id_transaccion"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getDouble("monto"),
                    resultSet.getDate("fecha")
                );
                transacciones.add(transaccion);
            }
            return transacciones;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
