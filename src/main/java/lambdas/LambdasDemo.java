package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdasDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a",
                "list", "of", "strings");

        // forEach takes a Consumer
        strings.forEach(s -> System.out.println(s));

        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(n -> System.out.println(n));

        // Define Consumer separately
        Consumer<Integer> printer = n -> System.out.println(n);
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(printer);

        System.out.println();
        // Predicate returns boolean
        Predicate<Integer> mod3 = n -> n % 3 == 0;
        Stream.of(3, 1, 4, 1, 5, 9)
                .filter(mod3)
                .forEach(printer);


        System.out.println();
        // Function of one type, returns one type
        Function<Integer, Integer> doubler = n -> n * 2;
        Stream.of(3, 1, 4, 1, 5, 9)
                .map(doubler)
                .filter(mod3)
                .forEach(printer);
    }
}
