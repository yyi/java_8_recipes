package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ReduceDemo {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + y).orElse(0);
        System.out.println(sum);

        sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d, y=%d%n", x, y);
                    return x + y;
                }).orElse(0);

        // Off-by-one error: first value doesn't get doubled
        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce((acc, n) -> acc + 2 * n).orElse(0);
        System.out.println(doubleSum);

        doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (acc, n) -> {
                    System.out.printf("Acc=%d, n=%d%n", acc, n);
                    return acc + 2 * n;
                });
        System.out.println(doubleSum);

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());
        System.out.println(sorted);

    }
}
