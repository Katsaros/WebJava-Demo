package app.endpoints;

import app.operators.MyOperator;
import com.megadeploy.annotations.core.Endpoint;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.annotations.request.Get;
import com.megadeploy.dataObjects.ApiResponse;
import com.megadeploy.enumerations.ApiStatus;

@Endpoint("/json")
public class JsonEndpoint {

    @AutoInitialize
    MyOperator myOperator;

    @Get("/")
    public ApiResponse<String> example() {
        return new ApiResponse<>("Hello, World!", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
    }

    @Get("/test")
    public ApiResponse<String> example2() {
        return new ApiResponse<>(myOperator.operatorName(), ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
    }
}