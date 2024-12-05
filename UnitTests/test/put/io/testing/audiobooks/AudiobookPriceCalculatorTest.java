package put.io.testing.audiobooks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class AudiobookPriceCalculatorTest {

    private Audiobook audiobook;
    private Customer customer;
    private AudiobookPriceCalculator calculator;


    @BeforeEach
    void setUp(){
        calculator = new AudiobookPriceCalculator();
    }

    @Test
    void testBlackBox(){
        customer = new Customer("cs1", Customer.LoyaltyLevel.STANDARD, false);
        audiobook = new Audiobook("au1", 125);

        assertEquals(125, calculator.calculate(customer, audiobook));

        customer = new Customer("cs1", Customer.LoyaltyLevel.STANDARD, false);
        audiobook = new Audiobook("au1", 135);

        assertEquals(135, calculator.calculate(customer, audiobook));

    };

    @Test
    void testSubscriber(){
        customer = new Customer("cs1", Customer.LoyaltyLevel.STANDARD, true);
        audiobook = new Audiobook("au1", 125);

        assertEquals(0, calculator.calculate(customer, audiobook));


    };
    @Test
    void testLoyaltySilver(){
        customer = new Customer("cs1", Customer.LoyaltyLevel.SILVER, false);
        audiobook = new Audiobook("au1", 125);

        assertEquals(0.9* 125, calculator.calculate(customer, audiobook));


    };
    @Test
    void testLoyaltyGold(){
        customer = new Customer("cs1", Customer.LoyaltyLevel.GOLD, false);
        audiobook = new Audiobook("au1", 125);

        assertEquals(0.8*125, calculator.calculate(customer, audiobook));


    };

    @Test
    void testPlainUser(){
        customer = new Customer("cs1", Customer.LoyaltyLevel.STANDARD, false);
        audiobook = new Audiobook("au1", 125);

        assertEquals(125, calculator.calculate(customer, audiobook));

    };
}