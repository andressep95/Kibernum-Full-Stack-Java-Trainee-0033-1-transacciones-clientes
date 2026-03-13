# Clase 6 - Módulo 5: Gestión de Clientes y Transacciones

Proyecto educativo Java web desarrollado como parte del **Módulo 5, Clase 6** del programa Kibernum. Implementa un sistema básico de gestión de clientes y transacciones con conexión a base de datos MySQL.

---

## Stack Tecnológico

| Capa | Tecnología |
|------|-----------|
| Lenguaje | Java |
| Frontend | JSP (Java Server Pages) |
| Build | Maven 4.0.0 |
| Base de datos | MySQL 8.4 |
| Infraestructura | Docker / Docker Compose |
| Testing | JUnit 5 (Jupiter) |
| Driver JDBC | mysql-connector-j 9.4.0 |

---

## Estructura del Proyecto

```
clase6/
├── src/
│   ├── main/
│   │   ├── java/cl/example/
│   │   │   ├── configuration/
│   │   │   │   └── DatabaseConnection.java     # Conexión JDBC (Singleton)
│   │   │   ├── model/
│   │   │   │   ├── Cliente.java                # Modelo cliente
│   │   │   │   └── Transaccion.java            # Modelo transacción
│   │   │   └── repository/
│   │   │       └── ClienteRepository.java      # Interfaz repositorio
│   │   └── webapp/
│   │       ├── WEB-INF/web.xml
│   │       └── index.jsp
│   └── test/
│       └── java/cl/example/configuration/
│           └── DatabaseConnectionTest.java     # Test de conexión
├── sql/
│   └── init.sql                                # Script de inicialización BD
├── docker-compose.yml
└── pom.xml
```

---

## Modelos de Datos

### Cliente
| Campo | Tipo | Descripción |
|-------|------|-------------|
| `id_cliente` | INT (PK, AI) | Identificador único |
| `nombre` | VARCHAR(100) | Nombre del cliente |
| `email` | VARCHAR(100) | Correo electrónico |

### Transaccion
| Campo | Tipo | Descripción |
|-------|------|-------------|
| `id_transaccion` | INT (PK, AI) | Identificador único |
| `id_cliente` | INT (FK) | Referencia al cliente |
| `monto` | DECIMAL(10,2) | Monto de la transacción |
| `fecha` | DATE | Fecha de la transacción |

Relación: `transacciones.id_cliente` → `clientes.id_cliente` (CASCADE UPDATE, RESTRICT DELETE)

---

## Componentes Implementados

### `DatabaseConnection` — Patrón Singleton
Gestiona la conexión JDBC a MySQL con las siguientes características:
- Instancia única (Singleton)
- Verificación de salud de la conexión
- Reconexión automática si la conexión se pierde
- URL: `jdbc:mysql://localhost:3306/repo`

### `ClienteRepository` — Interfaz Repositorio
Define el contrato para las operaciones CRUD sobre clientes:
- `crearCliente()`
- `actualizarCliente()`
- `obtenerClientePorId()`
- `obtenerCliente()`
- `eliminarCliente()`

> La implementación concreta del repositorio está pendiente.

### `DatabaseConnectionTest`
Test unitario con JUnit 5 que verifica que la conexión a la base de datos se establece correctamente (no nula y no cerrada).

---

## Levantar el Entorno

### Requisitos
- Docker y Docker Compose instalados
- Java 11+
- Maven 3.x+

### Pasos

```bash
# 1. Levantar la base de datos MySQL
docker compose up -d

# 2. Compilar el proyecto
mvn clean compile

# 3. Ejecutar los tests
mvn test

# 4. Empaquetar como WAR
mvn package
```

### Credenciales de la Base de Datos

| Parámetro | Valor |
|-----------|-------|
| Host | `localhost` |
| Puerto | `3306` |
| Base de datos | `repo` |
| Usuario | `user` |
| Contraseña | `password` |

---

## Estado del Avance

- [x] Configuración del proyecto Maven (WAR)
- [x] Infraestructura Docker con MySQL 8.4
- [x] Script SQL de inicialización de tablas
- [x] Modelo `Cliente`
- [x] Modelo `Transaccion`
- [x] Conexión JDBC con patrón Singleton (`DatabaseConnection`)
- [x] Interfaz `ClienteRepository`
- [x] Test de conexión a base de datos
- [ ] Implementación concreta de `ClienteRepository`
- [ ] Servlets / controladores web
- [ ] Vistas JSP para operaciones CRUD
- [ ] Implementación de `TransaccionRepository`

---

## Autor

**Andres Sepulveda** — andressep.95@gmail.com