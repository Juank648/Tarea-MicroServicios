package co.edu.eci.streamServices;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.json.JSONObject;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Stream hilo = new Stream();
        System.out.println("Hola Mundo desde Message");
        Gson gson = new Gson();
        port(getPort());
        get("/stream", (req, res) -> gson.toJson(hilo.getMensajes()));
        post("/add", (request, response)
                -> {
            if (request.body() != null) {//existe contenido
                try {
                    //Obtiene objeto JSON de tipo mensaje
                    Gson mensaje = gson.fromJson(request.body(), Gson.class);
                    hilo.addMensaje(mensaje);
                    response.status(201);//Codigo de respuesta
                    return gson.toJson(hilo.getMensajes());
                } catch (JsonParseException ex) {
                    response.status(400);//Bad Request
                    response.body("No se logro hacer el post");
                    return response;
                }
            } else {
                response.status(400);//Bad Request
                System.out.println("El objeto JSON es obligatorio");
                return response;

            }

        }, gson::toJson);

    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8002;
    }
}
