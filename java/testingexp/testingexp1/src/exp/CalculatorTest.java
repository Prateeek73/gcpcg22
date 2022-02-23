package exp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CalculatorTest {
    Calculator spy;
    Adder adder;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("inside beforeall");
    }

    @BeforeEach
    public void setup() {
        Calculator calculator = new Calculator();
        spy = spy(calculator);
        adder = mock(Adder.class);
        spy.setAdder(adder);
        System.out.println("inside setup");
    }

    @AfterEach
    public void clean() {
        System.out.println("inside clean");
        spy = null;
    }

    /**
     * scenario : numbers are positive
     * inputs : num1:2 , num2:3
     * expectation : result is 5
     */
    @Test
    public void testAdd_1() {
        System.out.println("inside tstAdd_1");
        when(adder.sum(2, 3)).thenReturn(5);
        int result = spy.add(2, 3);
        assertEquals(5, result);
    }


    /**
     * scenario : numbers are negative
     * inputs : num1:-2 , num2:-6
     * expectation : result is -8
     */
    @Test
    public void testAdd_2() {
        System.out.println("inside testAdd_2");
        when(adder.sum(-2, -6)).thenReturn(-8);
        int result = spy.add(-2, -6);
        assertEquals(-8, result);
    }

    @Test
    public void testAddBy10_1() {
        // when(spy.add(5,10)).thenReturn(15);
        doReturn(15).when(spy).add(5, 10);
        int result = spy.addBy10(5);
        assertEquals(15, result);
    }

}
