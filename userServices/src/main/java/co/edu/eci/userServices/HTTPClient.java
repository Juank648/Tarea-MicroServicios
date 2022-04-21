package co.edu.eci.userServices;

import com.google.gson.JsonObject;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class HTTPClient {
    private OkHttpClient httpClient;
    private String baseUrl="http://localhost";
    private String[] ports={":8001", ":8001"};
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private int serverNumber=0;

    public HTTPClient() {
        httpClient = new OkHttpClient();
    }

    public String getMessages(String path) throws IOException {

        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String postMessages(String path, String contenido) throws IOException {


        RequestBody requestBody = new FormBody.Builder()
                .add("descripcion", contenido)
                .build();
        System.out.println(requestBody.toString());
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .post(requestBody)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public void changePortToMessage(){
        this.serverNumber= 0;
    }

    public void changePortToStream() {
        this.serverNumber= 1;
    }
}
