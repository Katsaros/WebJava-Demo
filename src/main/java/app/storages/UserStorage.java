package app.storages;


import app.dataobjects.User;
import com.megadeploy.annotations.core.Storage;
import com.megadeploy.annotations.initializer.AutoInitialize;
import com.megadeploy.database.storagemanagers.InMemoryStorageManager;

import java.sql.SQLException;
import java.util.List;

@Storage
public class UserStorage {
    private final InMemoryStorageManager inMemoryStorageManager;

    @AutoInitialize
    public UserStorage(InMemoryStorageManager inMemoryStorageManager) {
        this.inMemoryStorageManager = inMemoryStorageManager;
    }

    public void createTable() throws SQLException {
        inMemoryStorageManager.createTable(User.class);
    }

    public void saveUser(User user) throws SQLException, IllegalAccessException, NoSuchFieldException {
        inMemoryStorageManager.save(user);
    }

    public void updateUser(User user) throws SQLException, IllegalAccessException, NoSuchFieldException {
        inMemoryStorageManager.update(user);
    }

    public void deleteUser(String id) throws SQLException {
        inMemoryStorageManager.delete(User.class, id);
    }

    // Retrieve a user by ID
    public User getUser(String id) throws SQLException {
        return inMemoryStorageManager.get(User.class, id);
    }

    // Retrieve all users
    public List<User> getAllUsers() throws SQLException {
        return inMemoryStorageManager.getAll(User.class);
    }
}
