package co.edu.eci.userServices;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        port(getPort());

        HTTPClient client=new HTTPClient();
        get("/", (req, res) -> "Hello World from Usuario!!!");

        get("/stream",(req, res) -> {
            Gson gson = new Gson();
            client.changePortToStream();
            res.status(200);
            res.type("application/json");
            String response=client.getMessages("/stream");
            return gson.toJson(response);
        });

        post("/message",(req, res) -> {
            Gson gson = new Gson();
            client.changePortToMessage();
            res.status(200);
            res.type("application/json");
            String mensaje = req.body();
            JSONObject json = new JSONObject(mensaje);
            String contenido = json.getString("descripcion");

            String response = client.postMessages("/message", contenido);
            /*
            client.changePortToStream();
            RequestBody madd = gson.fromJson(response, RequestBody.class);
            String stream =client.postMessages("/add", madd);
            //Gson response=client.getMessages("/log?value="+value);

            */
            //return gson.toJson(response);
            return response;
        });

    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8000;
    }
}
