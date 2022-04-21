package co.edu.eci.streamServices;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Stream {
    private String id;
    private List<Gson> mensajes;

    public Stream() {
        this.id = UUID.randomUUID().toString();
        mensajes = new ArrayList<Gson>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Gson> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Gson> mensajes) {
        this.mensajes = mensajes;
    }

    public void addMensaje(Gson mensaje){
        mensajes.add(mensaje);
    }
}
