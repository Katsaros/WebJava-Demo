package app.endpoints;

import com.megadeploy.annotations.core.Endpoint;
import com.megadeploy.annotations.request.*;

@Endpoint("/api")
public class HelloEndpoint {

    @Get("/hello")
    public void sayHello() {
        System.out.println("Hello, World!");
    }

    @Post("/")
    public void createHello() {
        System.out.println("Hello created!");
    }

    @Put("/")
    public void updateHello() {
        System.out.println("Hello updated!");
    }

    @Delete("/")
    public void deleteHello() {
        System.out.println("Hello deleted!");
    }
}