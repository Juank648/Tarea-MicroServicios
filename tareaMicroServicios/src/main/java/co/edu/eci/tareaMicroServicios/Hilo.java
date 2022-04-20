package co.edu.eci.tareaMicroServicios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hilo {
    private String id;
    private List<Mensaje> mensajes;

    public Hilo() {
        this.id = UUID.randomUUID().toString();
        mensajes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public void addMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }
}
