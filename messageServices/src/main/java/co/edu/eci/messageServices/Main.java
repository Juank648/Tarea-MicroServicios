package co.edu.eci.messageServices;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import okhttp3.RequestBody;
import org.json.JSONObject;

import java.lang.reflect.Type;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        System.out.println("Hola Mundo desde Message");
        Gson gson = new Gson();
        port(getPort());
        get("/message", (req, res) -> gson.toJson(message));
        post("/message", (request, response)
                -> {
            if (request.body() != null) {//existe contenido
                try {
                    System.out.println("//////////////");
                    System.out.println(request.body());
                    //Obtiene objeto JSON de tipo mensaje
                    
                    Message mensaje = new Message("fhdfb");

                    if(mensaje.getDescripcion().length() > 140){
                        response.status(400);//Bad Request
                        response.body("Longitud no permitida");
                        System.out.println("Longitud no permitida");
                        return response;
                    }else{
                        message.setDescripcion(mensaje.getDescripcion());
                        message.setId();
                        message.setFecha();
                        response.status(201);//Codigo de respuesta
                        return gson.toJson(message);
                    }
                } catch (JsonParseException ex) {
                    System.out.println("*******************");
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
