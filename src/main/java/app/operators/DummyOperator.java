package app.operators;

import app.dataobjects.Task;
import app.dataobjects.User;
import app.storages.DummyStorage;
import app.storages.UserStorage;
import com.megadeploy.annotations.core.Operator;
import com.megadeploy.annotations.initializer.AutoInitialize;

import java.sql.SQLException;
import java.util.List;

@Operator
public class DummyOperator {

    private final DummyStorage dummyStorage;

    @AutoInitialize
    public DummyOperator(DummyStorage dummyStorage) {
        this.dummyStorage = dummyStorage;
    }

    public void saveDummy(Task task) throws SQLException, NoSuchFieldException, IllegalAccessException {
        dummyStorage.save(task);
    }

}
