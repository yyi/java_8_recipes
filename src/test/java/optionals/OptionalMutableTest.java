package optionals;

import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class OptionalMutableTest {
    private AtomicInteger counter = new AtomicInteger();
    private Optional<AtomicInteger> optional = Optional.ofNullable(counter);

    @Test
    public void quickDemo() throws Exception {
        System.out.println(optional); // Optional[0]

        // increment using counter directly
        counter.incrementAndGet();
        System.out.println(optional); // Optional[1]

        // increment using Optional value
        optional.get().incrementAndGet();
        System.out.println(optional); // Optional[2]
    }

    @Test
    public void immutableDoesNotMeanFinal() throws Exception {
        optional = Optional.ofNullable(new AtomicInteger());
        // no exception thrown
    }

    @Test
    public void nonEmpty() throws Exception {
        assertTrue(optional.isPresent());
    }

    @Test
    public void canAccessCounter() throws Exception {
        AtomicInteger local = optional.get();
        assertEquals(counter, local);
    }

    @Test
    public void canChangeCounterViaRef() throws Exception {
        int before = counter.get();
        assertEquals(before, optional.get().get());
        int after = counter.incrementAndGet();
        assertEquals(after, optional.get().get());
    }

    @Test
    public void canChangeCounterViaOptional() throws Exception {
        int before = optional.get().get();
        optional.get().incrementAndGet();
        int after = optional.get().get();
        assertEquals(before + 1, after);
    }
}
