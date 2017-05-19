package concurrency;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SequentialToParallelTest {
    @Test
    public void sequentialStreamOf() throws Exception {
        assertFalse(Stream.of(3, 1, 4, 1, 5, 9).isParallel());
    }

    @Test
    public void sequentialIterateStream() throws Exception {
        assertFalse(Stream.iterate(1, n -> n + 1).isParallel());
    }

    @Test
    public void sequentialGenerateStream() throws Exception {
        assertFalse(Stream.generate(Math::random).isParallel());
    }

    @Test
    public void sequentialCollectionStream() throws Exception {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertFalse(numbers.stream().isParallel());
    }

    @Test
    public void parallelMethodOnStream() throws Exception {
        assertTrue(Stream.of(3, 1, 4, 1, 5, 9)
                .parallel()
                .isParallel());
    }

    @Test
    public void parallelStreamMethodOnCollection() throws Exception {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertTrue(numbers.parallelStream().isParallel());
    }

    @Test
    public void parallelStreamThenSequential() throws Exception {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertFalse(numbers.parallelStream()
                .sequential()
                .isParallel());
    }

    @Test
    public void switchingParallelToSequentialInSameStream() throws Exception {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        List<Integer> nums = numbers.parallelStream()
                .map(n -> n * 2)
                .peek(n -> System.out.printf("%s processing %d%n", Thread.currentThread().getName(), n))
                .sequential()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(nums);
    }
}