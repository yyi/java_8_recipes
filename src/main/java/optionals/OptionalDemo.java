package optionals;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> firstEven = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 == 0)
                .findFirst();

        System.out.println(firstEven);
        firstEven.ifPresent(System.out::println);
        System.out.println(firstEven.isPresent() ? firstEven.get() : "No even length strings");
        System.out.println(firstEven.orElse("No even length strings"));

        Optional<String> firstOdd = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 != 0)
                .findFirst();

        System.out.println(firstOdd);
        firstOdd.ifPresent(System.out::println);
        System.out.println(firstOdd.isPresent() ? firstOdd.get() : "No odd length strings");
        System.out.println(firstOdd.orElse("No odd length strings"));
    }
}
