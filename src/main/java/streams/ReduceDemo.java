package streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        sum = IntStream.rangeClosed(1, 10)
                .reduce(Integer::sum).orElse(0);


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

        doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, Integer::sum);
        System.out.println(doubleSum);

        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> {
                    System.out.println("acc=" + acc + ", val=" + val);
                    return acc.add(val);
                });
        System.out.println("The total is " + total);


        List<Book> books = Arrays.asList(
                new Book(1, "Modern Java Recipes"),
                new Book(2, "Making Java Groovy"),
                new Book(3, "Gradle Recipes for Android"));

        // Note: this is the HARD way; see AddCollectionToMap for easier ways
        HashMap<Integer, Book> bookMap = books.stream()
                .reduce(new HashMap<Integer, Book>(),  // identity for putAll
                        (map, book) -> {               // add a single book to map
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) -> {              // join multiple maps
                            map1.putAll(map2);
                            return map1;
                        });

        bookMap.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
