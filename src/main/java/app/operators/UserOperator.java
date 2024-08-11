package app.operators;

import app.storages.UserStorage;
import com.megadeploy.annotations.core.Operator;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.storages.InMemoryStorage;

import java.sql.ResultSet;
import java.sql.SQLException;

@Operator
public class UserOperator {

    private UserStorage userStorage;

    @AutoInitialize
    public UserOperator(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void createMyTable() throws SQLException {
        String tableDefinition = "id INT PRIMARY KEY, name VARCHAR(255)";
        userStorage.createTable("UserTable", tableDefinition);
    }

    public void insertMyData(int id, String name) throws SQLException {
        userStorage.insertData("MyTable", "id, name", id + ", '" + name + "'");
    }

    public ResultSet getMyData(int id) throws SQLException {
        return userStorage.getData("MyTable", "*", "id = " + id);
    }

    public void updateMyData(int id, String newName) throws SQLException {
        userStorage.updateData("MyTable", "name = '" + newName + "'", "id = " + id);
    }

    public void deleteMyData(int id) throws SQLException {
        userStorage.deleteData("MyTable", "id = " + id);
    }
}
