package app.operators;

import com.megadeploy.annotations.core.Operator;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.annotations.operators.InMemoryDatabaseOperator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Operator
public class MyInMemoryOperator extends InMemoryDatabaseOperator {

    @AutoInitialize
    public MyInMemoryOperator(Connection connection) {
        super(connection);
    }

    public void createMyTable() throws SQLException {
        String tableDefinition = "id INT PRIMARY KEY, name VARCHAR(255)";
        createTable("MyTable", tableDefinition);
    }

    public void insertMyData(int id, String name) throws SQLException {
        insertData("MyTable", "id, name", id + ", '" + name + "'");
    }

    public ResultSet getMyData(int id) throws SQLException {
        return getData("MyTable", "*", "id = " + id);
    }

    public void updateMyData(int id, String newName) throws SQLException {
        updateData("MyTable", "name = '" + newName + "'", "id = " + id);
    }

    public void deleteMyData(int id) throws SQLException {
        deleteData("MyTable", "id = " + id);
    }
}
