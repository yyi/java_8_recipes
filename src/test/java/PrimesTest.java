import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PrimesTest {
    private Primes p = new Primes();

    @Test // Iterative
    public void testIsPrime() throws Exception {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        for (int n : primes) {
            assertTrue(String.format("%d is prime", n), p.isPrime(n));
        }

        assertFalse(p.isPrime(4));
    }

    @Test // Functional :)
    public void testIsPrimeWithStreams() throws Exception {
        assertTrue(Stream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .allMatch(p::isPrime));
    }

    @Test
    public void testNextPrime() {
        assertEquals(2, p.nextPrime(1));
        assertEquals(3, p.nextPrime(2));
        assertEquals(5, p.nextPrime(3));
        assertEquals(5, p.nextPrime(4));
        assertEquals(7, p.nextPrime(5));
        assertEquals(7, p.nextPrime(6));
    }

    @Test
    public void testNextPrimeUsingMap() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 5, 7, 7);

        List<Integer> computed = Stream.of(1, 2, 3, 4, 5, 6)
                .map(p::nextPrime)
                .collect(Collectors.toList());

        assertTrue(expected.equals(computed));
    }
}