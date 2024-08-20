package app.operators;

import app.dataobjects.User;
import app.storages.UserStorage;
import com.megadeploy.annotations.core.Operator;
import com.megadeploy.annotations.initializer.AutoInitialize;
import java.sql.SQLException;
import java.util.List;

@Operator
public class UserOperator {

    private final UserStorage userStorage;

    @AutoInitialize
    public UserOperator(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void createUser(String name, int age) throws SQLException, IllegalAccessException, NoSuchFieldException {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userStorage.saveUser(user);
    }

    public void updateUser(String id, String name, int age) throws SQLException, IllegalAccessException, NoSuchFieldException {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userStorage.updateUser(user);
    }

    public void deleteUser(String id) throws SQLException {
        userStorage.deleteUser(id);
    }

    // Get a user by ID
    public User getUser(String id) throws SQLException {
        return userStorage.getUser(id);
    }

    // Get all users
    public List<User> getAllUsers() throws SQLException {
        return userStorage.getAllUsers();
    }
}
