package app.storages;


import com.megadeploy.annotations.core.Storage;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.storages.InMemoryStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Storage
public class UserStorage extends InMemoryStorage {

    @AutoInitialize
    public UserStorage(Connection connection) {
        super(connection);
    }

    public void createMyCustomTable() throws SQLException {
        String tableDefinition = "id INT PRIMARY KEY, name VARCHAR(255)";
        createTable("MyCustomTable", tableDefinition);
    }

    public void insertCustomData(int id, String name) throws SQLException {
        insertData("MyCustomTable", "id, name", id + ", '" + name + "'");
    }

    public ResultSet getCustomData(int id) throws SQLException {
        return getData("MyCustomTable", "*", "id = " + id);
    }

    public void updateCustomData(int id, String newName) throws SQLException {
        updateData("MyCustomTable", "name = '" + newName + "'", "id = " + id);
    }

    public void deleteCustomData(int id) throws SQLException {
        deleteData("MyCustomTable", "id = " + id);
    }
}
