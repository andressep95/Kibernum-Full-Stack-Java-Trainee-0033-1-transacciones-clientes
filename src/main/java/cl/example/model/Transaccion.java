package cl.example.model;

import java.util.Date;

public class Transaccion {

    private Integer transaccionId;
    private Integer clienteId;
    private Double monto;
    private Date fecha;

    public Transaccion(Integer transaccionId, Integer clienteId, Double monto, Date fecha) {
        this.transaccionId = transaccionId;
        this.clienteId = clienteId;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Integer getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
            "transaccionId=" + transaccionId +
            ", clienteId=" + clienteId +
            ", monto=" + monto +
            ", fecha=" + fecha +
            '}';
    }
}
