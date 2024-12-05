package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FailureOrErrorTest {


    @Test
    void test1(){
        assertEquals(1, 0);
    }


    @Test
    void test2(){
        int a = 1/0;
    }

    @Test
    void test3(){
        try{
            assertEquals(1, 0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
