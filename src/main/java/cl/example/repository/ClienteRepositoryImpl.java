package cl.example.repository;

import cl.example.configuration.DatabaseConnection;
import cl.example.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRepositoryImpl implements ClienteRepository {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public Integer crearCliente(Cliente cliente) {

        String query = "INSERT INTO clientes (nombre, email) VALUES (?, ?)";

        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS)
            ) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getEmail());

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
    public void actualizarCliente(Cliente cliente) {
        String query = "UPDATE clientes SET nombre = ?, email = ? WHERE id_cliente = ?";

        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setInt(3, cliente.getClienteId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(int idCliente) {
        String query = "DELETE FROM clientes WHERE id_cliente = ?";

        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
            preparedStatement.setInt(1, idCliente);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente obtenerCliente(int idCliente) {

        String query = "SELECT id_cliente, nombre, email FROM clientes WHERE id_cliente = ?";
        try (
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, idCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer clienteId = resultSet.getInt("id_cliente");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");

                return new Cliente(clienteId, nombre, email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
