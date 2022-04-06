package co.edu.eci.tareaMicroServicios;

import java.util.Date;
import java.util.UUID;

public class Mensaje {
    public String id;
    public String descripcion;
    public Date fecha;
    public Usuario usuario;

    public Mensaje(String descripcion, Usuario usuario) {
        this.id = UUID.randomUUID().toString();
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.fecha = new Date();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
