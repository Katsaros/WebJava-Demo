package app;

import com.megadeploy.core.WebJavaServer;

public class Main {
    public static void main(String[] args) {
        try {
            WebJavaServer server = new WebJavaServer(8080, Main.class);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}