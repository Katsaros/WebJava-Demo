package app.endpoints;

import app.dataobjects.User;
import app.operators.UserOperator;
import com.megadeploy.annotations.core.Endpoint;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.annotations.request.Get;
import com.megadeploy.annotations.request.Post;
import com.megadeploy.enumerations.ApiStatus;
import com.megadeploy.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

@Endpoint("/user")
public class UserEndpoint {

    private final UserOperator userOperator;

    @AutoInitialize
    public UserEndpoint(UserOperator userOperator) {
        this.userOperator = userOperator;
    }

    @Post("/create")
    public ApiResponse<String> createUser(/*@RequestBody User user*/) {
        try {
            String name = "dummy";
            int age = 22;
            userOperator.createUser(name, age);
            return new ApiResponse<>("User created successfully", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
        } catch (Exception e) {
            return new ApiResponse<>("Failed to create user: " + e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_MESSAGE, ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

    @Get("/get/{id}")
    public ApiResponse<User> getUser(/*@PathParam("id") String id*/) {
        try {
            UUID id = UUID.randomUUID();
            User user = userOperator.getUser(id.toString());
            if (user != null) {
                return new ApiResponse<>(user, ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
            } else {
                return new ApiResponse<>(null, "User not found", ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
            }
        } catch (Exception e) {
            return new ApiResponse<>(null, "Failed to get user: " + e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

    @Get("/get-all")
    public ApiResponse<List<User>> getAllUsers() {
        try {
            List<User> users = userOperator.getAllUsers();
            if (users != null && !users.isEmpty()) {
                return new ApiResponse<>(users, ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
            } else {
                return new ApiResponse<>(null, "Users not found", ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
            }
        } catch (Exception e) {
            return new ApiResponse<>(null, "Users exception: " + e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

    @Post("/update")
    public ApiResponse<String> updateUser(@RequestBody User user) {
        try {
            UUID id = UUID.randomUUID();
            String name = "dummy";
            int age = 22;
            userOperator.updateUser(id.toString(), name, age);
            return new ApiResponse<>("User updated successfully", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
        } catch (Exception e) {
            return new ApiResponse<>("Failed to update user: " + e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_MESSAGE, ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

    @Post("/delete/{id}")
    public ApiResponse<String> deleteUser(/*@PathParam("id") String id*/) {
        try {
            UUID id = UUID.randomUUID();
            userOperator.deleteUser(id.toString());
            return new ApiResponse<>("User deleted successfully", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
        } catch (Exception e) {
            return new ApiResponse<>("Failed to delete user: " + e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_MESSAGE, ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }
}

