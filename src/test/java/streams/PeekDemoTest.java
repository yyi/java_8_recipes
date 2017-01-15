package streams;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeekDemoTest {
    private PeekDemo demo = new PeekDemo();

    @Test
    public void sumUpTo() throws Exception {
        assertEquals(55,   demo.sumUpTo(10));
        assertEquals(5050, demo.sumUpTo(100));
    }

    @Test
    public void sumEachDoubleUpTo() throws Exception {
        assertEquals(2 * 55,   demo.sumEachDoubleUpTo(10));
        assertEquals(2 * 5050, demo.sumEachDoubleUpTo(100));
    }

    @Test
    public void sumDoublesDivisibleBy3() throws Exception {
        assertEquals(1554, demo.sumDoublesDivisibleBy3(100, 120));
    }
}