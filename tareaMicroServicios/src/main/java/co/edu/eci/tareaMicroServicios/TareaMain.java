package co.edu.eci.tareaMicroServicios;

import com.google.gson.JsonParseException;
import com.google.gson.*;

import static spark.Spark.*;

public class TareaMain {

    private static Hilo hilo = new Hilo();

    public static void main(String[] args) {
        Mensaje prueba = new Mensaje("Prueba 1");
        Mensaje prueba2 = new Mensaje("Prueba 2");
        hilo.addMensaje(prueba);
        hilo.addMensaje(prueba2);
        Gson gson = new Gson();
        System.out.println("Hello World");
        port(getPort());
        get("/stream", (req, res) -> gson.toJson(hilo.getMensajes()));
        post("/message", (request, response)
                -> {
            if (request.body() != null) {//existe contenido
                try {
                    //Obtiene objeto JSON de tipo mensaje
                    Mensaje mensaje = gson.fromJson(request.body(), Mensaje.class);
                    if(mensaje.getDescripcion().length() > 140){
                        response.status(400);//Bad Request
                        response.body("Longitud no permitida");
                        System.out.println("Longitud no permitida");
                        return response;
                    }else{
                        mensaje.setFecha();
                        hilo.addMensaje(mensaje);
                        response.status(201);//Codigo de respuesta
                        return gson.toJson(hilo.getMensajes());
                    }
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
        return 8001;
    }
}
