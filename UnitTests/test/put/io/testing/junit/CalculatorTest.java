package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition(){
        assertEquals(20, calculator.add(10, 10));
        assertEquals(20, calculator.add(8, 12));
    };

    @Test
    void testMultiplication(){
        assertEquals(20, calculator.multiply(5, 4));
        assertEquals(169, calculator.multiply(13, 13));

    };

    @Test
    void testAddPositiveNumbers(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-1, 1);
        });
    }

}

//3.1
/*testy przestały by działąć ze względu na wymaganie metody statycznej przez beforeall*/


//4.1
/*test1- failure niepoprawny wynik, test2-error nieoczekiwany błąd*/

//4.2
/*assertion error*/

//5.1
/*whitebox*/

//5.2
/*4*/