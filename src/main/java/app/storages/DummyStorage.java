package app.storages;


import app.dataobjects.Task;
import com.megadeploy.annotations.core.Storage;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.database.storagemanagers.DummyStorageManager;

import java.sql.SQLException;

@Storage
public class DummyStorage {
    private final DummyStorageManager dummyStorageManager;

    @AutoInitialize
    public DummyStorage(DummyStorageManager dummyStorageManager) {
        this.dummyStorageManager = dummyStorageManager;
    }

    public void createTable() throws SQLException {
        dummyStorageManager.createTable(Task.class);
    }

    public void save(Task task) throws SQLException, IllegalAccessException, NoSuchFieldException {
        dummyStorageManager.save(task);
    }

    public void update(Task task) throws SQLException, IllegalAccessException, NoSuchFieldException {
        dummyStorageManager.update(task);
    }

    public void delete(String id) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        dummyStorageManager.delete(Task.class, id);
    }

//    // Retrieve a user by ID
//    public User getUser(String id) throws SQLException {
//        return dummyStorageManager.get(User.class, id);
//    }
//
//    // Retrieve all users
//    public List<User> getAllUsers() throws SQLException {
//        return dummyStorageManager.getAll(User.class);
//    }
}
