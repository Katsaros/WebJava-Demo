package app;

import app.endpoints.HelloEndpoint;
import com.megadeploy.core.WebJavaServer;
import com.megadeploy.endpoints.StatusEndpoint;

public class Main {
    public static void main(String[] args) {
        WebJavaServer server = new WebJavaServer(8080);
        server.addEndpoint(new HelloEndpoint());
        server.addEndpoint(new StatusEndpoint());

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}