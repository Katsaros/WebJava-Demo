package app.endpoints;

import com.megadeploy.annotations.core.Endpoint;
import com.megadeploy.annotations.request.Get;
import com.megadeploy.responses.ApiResponse;
import com.megadeploy.enumerations.ApiStatus;

@Endpoint("/json")
public class JsonEndpoint {

    @Get("/")
    public ApiResponse<String> example() {
        return new ApiResponse<>("Hello, World!", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
    }

}