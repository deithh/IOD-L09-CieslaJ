package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.InOrder.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        IFancyDatabase db = mock(IFancyDatabase.class);
        when(db.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository er = new ExpenseRepository(db);
        er.loadExpenses();

        InOrder inOrd = inOrder(db);
        inOrd.verify(db).connect();
        inOrd.verify(db).close();

        assertEquals(0, er.getExpenses().size());
    }

    @Test
    void saveExpenses() {
        IFancyDatabase db = mock(IFancyDatabase.class);
        when(db.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository er = new ExpenseRepository(db);
        for (int i = 0; i < 5; i++) {
            Expense ex = new Expense();
            er.addExpense(ex);
        }
        er.saveExpenses();

        verify(db, times(5)).persist(any(Expense.class));
    }
}
