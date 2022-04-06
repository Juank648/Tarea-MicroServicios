package co.edu.eci.tareaMicroServicios;

import static spark.Spark.*;

public class TareaMain {
    public static void main(String[] args){

        System.out.println("Hello World");
        port(getPort());
        /*
        get("/hello", (req, res) -> "Hello Heroku");
        get("/acos", (req, res) -> getRespuesta(req, res, "acos"));
        get("/log", (req,res) -> getRespuesta(req, res, "log"));*/
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8001;
    }
}
