package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.testing.mocks.IExpenseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class myDatabase implements IFancyDatabase {

    @Override
    public void connect(){
        return;
    }

    @Override
    public <T> void persist(T t) {
        return;
    }
    @Override
    public <T> java.util.List<T> queryAll(){
        return Collections.emptyList();
    }

    @Override
    public void close() {
        return;
    }
}
