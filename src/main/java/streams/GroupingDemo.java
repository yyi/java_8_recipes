package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");

        Map<Integer, List<String>> lengthMap = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        lengthMap.forEach((k, v) -> System.out.printf("%d: %s%n", k, v));

        strings.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.counting()));

        strings.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.minBy(Comparator.comparingInt(String::length))));

        strings.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.maxBy(Comparator.comparingInt(String::length))));

    }
}
