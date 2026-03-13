package cl.example.model;

public class Cliente {

    private Integer clienteId;
    private String nombre;
    private String email;

    public Cliente(Integer clienteId, String nombre, String email) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.email = email;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "clienteId=" + clienteId +
            ", nombre='" + nombre + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
