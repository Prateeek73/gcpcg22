package exp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest2 {
    @Mock
    Adder adder;

    @Spy
    @InjectMocks
    Calculator spy;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("inside beforeall");
    }

    @BeforeEach
    public void setup() {
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
        verify(adder).sum(-2,-6);
    }

    @Test
    public void testAddBy10_1() {
        // when(spy.add(5,10)).thenReturn(15);
        doReturn(15).when(spy).add(5, 10);
        int result = spy.addBy10(5);
        assertEquals(15, result);
        verify(spy).add(5,10);
    }

}
