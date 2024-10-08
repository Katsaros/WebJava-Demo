package app.operators;

import com.megadeploy.annotations.core.Operator;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.annotations.operators.InMemoryDatabaseOperator;
import com.megadeploy.storages.InMemoryStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Operator
public class MyInMemoryOperator {

    private InMemoryStorage myInMemoryStorage;

    @AutoInitialize
    public MyInMemoryOperator(InMemoryStorage inMemoryStorage) {
        this.myInMemoryStorage = inMemoryStorage;
    }

    public void createMyTable() throws SQLException {
        String tableDefinition = "id INT PRIMARY KEY, name VARCHAR(255)";
        myInMemoryStorage.createTable("MyTable", tableDefinition);
    }

    public void insertMyData(int id, String name) throws SQLException {
        myInMemoryStorage.insertData("MyTable", "id, name", id + ", '" + name + "'");
    }

    public ResultSet getMyData(int id) throws SQLException {
        return myInMemoryStorage.getData("MyTable", "*", "id = " + id);
    }

    public void updateMyData(int id, String newName) throws SQLException {
        myInMemoryStorage.updateData("MyTable", "name = '" + newName + "'", "id = " + id);
    }

    public void deleteMyData(int id) throws SQLException {
        myInMemoryStorage.deleteData("MyTable", "id = " + id);
    }
}
