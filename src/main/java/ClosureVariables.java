import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosureVariables {
    public static void main(String[] args) {


        int total = 0;
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        for (Integer n : nums) {
            total += n;
        }
        System.out.printf("The total is %d%n", total);

        // Won't compile
        total = 0;
        Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .forEach(n -> {
                            // Can't modify "total"
                            // total += n
                        }
                );


        List<String> strings = Arrays.asList("this", "is", "a",
                "list", "of", "strings");

        // Side effects --> legal, but not safe
        List<String> evenLengths = new ArrayList<>();
        strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .forEach(evenLengths::add);
        System.out.println(evenLengths);

        // No side-effects
        List<String> evens = strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens);

    }
}
