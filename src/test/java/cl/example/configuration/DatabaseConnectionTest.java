package cl.example.configuration;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    // Conexion a db
    private final DatabaseConnection dbConnection = DatabaseConnection.getInstance();

    @Test
    void testGetConnection() throws SQLException {
        // Generamos la conexión a la base de datos
        Connection connection = dbConnection.getConnection();
        System.out.println(connection);
        System.out.println(connection.isClosed());
        assertNotNull(connection, "La conexión no debe ser nula");
        assertFalse(connection.isClosed());
    }

}