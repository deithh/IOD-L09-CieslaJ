package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

import static org.mockito.Mockito.*;
import static org.mockito.InOrder.*;
import java.util.Collections;

public class ExpenseManagerTest {

    @Test
    public void calculateTotal(){
        ExpenseRepository er = mock(ExpenseRepository.class);
        List<Expense> list = new ArrayList<Expense>();
        for (int i = 0; i < 3; i++) {
            Expense ex = new Expense();
            ex.setAmount(i+10);
            list.add(ex);
        }
        when(er.getExpenses()).thenReturn(list);

        FancyService fs = mock(FancyService.class);

        ExpenseManager em = new ExpenseManager(er, fs);

        long res = em.calculateTotal();
        assertEquals(33, res);
    }

    @Test
    public void calculateTotalForCategory(){
        ExpenseRepository er = mock(ExpenseRepository.class);
        List<Expense> home = new ArrayList<Expense>();
        Expense ex1 = new Expense();
        Expense ex2 = new Expense();
        ex1.setAmount(10);
        ex2.setAmount(20);
        home.add(ex1);
        home.add(ex2);

        List<Expense> car = new ArrayList<Expense>();
        Expense ex3 = new Expense();
        Expense ex4 = new Expense();
        ex3.setAmount(5);
        ex4.setAmount(7);
        car.add(ex3);
        car.add(ex4);

        when(er.getExpensesByCategory(anyString())).thenReturn(Collections.emptyList());
        when(er.getExpensesByCategory("Home")).thenReturn(home);
        when(er.getExpensesByCategory("Car")).thenReturn(car);


        FancyService fn = mock(FancyService.class);
        ExpenseManager em = new ExpenseManager(er, fn);

        assertEquals(30, em.calculateTotalForCategory("Home"));
        assertEquals(12, em.calculateTotalForCategory("Car"));
        assertEquals(0, em.calculateTotalForCategory("Food"));
        assertEquals(0, em.calculateTotalForCategory("Sport"));
    }

    @Test
    public void calculateTotalInDollars() throws ConnectException{
        ExpenseRepository er = mock(ExpenseRepository.class);
        FancyService fn = mock(FancyService.class);

        Expense ex1 = new Expense();
        ex1.setAmount(10);
        Expense ex2 = new Expense();
        ex2.setAmount(20);
        Expense ex3 = new Expense();
        ex3.setAmount(30);
        when(er.getExpenses()).thenReturn(List.of(ex1, ex2, ex3));

        when(fn.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(invocation -> {
            double amountInPln = invocation.getArgument(0);
            return amountInPln / 4.0;
        });

        when(fn.convert(anyDouble(), eq("PLN"), eq("USD"))).thenThrow(new ConnectException());
        ExpenseManager em = new ExpenseManager(er, fn);

        double res = em.calculateTotalInDollars();
        assertEquals(15.0, res);
    }
}
