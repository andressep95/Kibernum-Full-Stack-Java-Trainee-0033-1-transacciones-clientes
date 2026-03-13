CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE transacciones (
  id_transaccion INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  monto DECIMAL(10,2) NOT NULL,
  fecha DATE NOT NULL,
  PRIMARY KEY (id_transaccion),
  CONSTRAINT fk_transacciones_clientes
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
ON UPDATE CASCADE
ON DELETE RESTRICT
);