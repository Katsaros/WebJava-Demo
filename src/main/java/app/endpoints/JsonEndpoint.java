package app.endpoints;

import app.dataobjects.Task;
import com.megadeploy.annotations.core.Endpoint;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.annotations.request.Get;
import com.megadeploy.database.storagemanagers.DummyStorageManager;
import com.megadeploy.responses.ApiResponse;
import com.megadeploy.enumerations.ApiStatus;

import java.sql.SQLException;
import java.util.UUID;

@Endpoint("/json")
public class JsonEndpoint {

    @AutoInitialize
    DummyStorageManager dummyStorageManager;

    @Get("/")
    public ApiResponse<String> example() {
        return new ApiResponse<>("Hello, World!", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
    }


    @Get("/test")
    public ApiResponse<Task> exampleFromDummyStorageManager() throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        return new ApiResponse<>(dummyStorageManager.get(Task.class, UUID.randomUUID().toString()), ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
    }
}