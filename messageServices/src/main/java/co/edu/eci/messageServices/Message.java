package co.edu.eci.messageServices;

import java.util.Date;
import java.util.UUID;

public class Message {
    public String id;
    public String descripcion;
    public Date fecha;
    public String usuario;

    public Message(String descripcion, String usuario) {
        this.id = UUID.randomUUID().toString();
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.fecha = new Date();
    }

    public Message(String descripcion) {
        this.id = UUID.randomUUID().toString();
        this.descripcion = descripcion;
        this.fecha = new Date();
    }
    public Message() {
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

    public void setFecha() {
        this.fecha = new Date();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }
}
