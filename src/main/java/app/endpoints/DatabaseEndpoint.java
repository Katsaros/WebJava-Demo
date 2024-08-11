package app.endpoints;

import app.operators.MyInMemoryOperator;
import com.megadeploy.annotations.core.Endpoint;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.annotations.request.Get;
import com.megadeploy.annotations.request.Post;
import com.megadeploy.responses.ApiResponse;
import com.megadeploy.enumerations.ApiStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

@Endpoint("/db")
public class DatabaseEndpoint {

    @AutoInitialize
    private MyInMemoryOperator myInMemoryOperator;

    @Get("/create")
    public ApiResponse<String> createTable() {
        try {
            myInMemoryOperator.createMyTable();
            return new ApiResponse<>("Table created successfully", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
        } catch (SQLException e) {
            return new ApiResponse<>(e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_MESSAGE, ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

    @Post("/insert")
    public ApiResponse<String> insertData() {
        try {
            myInMemoryOperator.insertMyData(1, "John Doe");
            return new ApiResponse<>("Data inserted successfully", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
        } catch (SQLException e) {
            return new ApiResponse<>(e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_MESSAGE, ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

    @Get("/get")
    public ApiResponse<String> getData() {
        try {
            ResultSet rs = myInMemoryOperator.getMyData(1);
            if (rs.next()) {
                return new ApiResponse<>("Data: " + rs.getString("name"), ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
            } else {
                return new ApiResponse<>("No data found", ApiStatus.SUCCESS_MESSAGE, ApiStatus.SUCCESS_STATUS);
            }
        } catch (SQLException e) {
            return new ApiResponse<>(e.getMessage(), ApiStatus.INTERNAL_SERVER_ERROR_MESSAGE, ApiStatus.INTERNAL_SERVER_ERROR_STATUS);
        }
    }

}
