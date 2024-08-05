package app.endpoints;

import app.dataobjects.user.User;
import com.megadeploy.annotations.*;

@Endpoint("/json")
public class JsonEndpoint {

    @Get("/")
    public void getADataObjectSerialized() {
        User user = new User();

//        user.setFullName();
    }
}