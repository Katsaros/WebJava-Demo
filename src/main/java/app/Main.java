package app;

import com.megadeploy.core.WebJavaServer;

public class Main {
    public static void main(String[] args) {
        WebJavaServer server = new WebJavaServer(8080, Main.class);

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}