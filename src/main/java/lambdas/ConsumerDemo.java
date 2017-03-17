package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        // Lambda expression
        integers.forEach(n -> System.out.println("The current value is " + n));

        // Method reference
        integers.forEach(System.out::println);

        Set<Integer> nums = integers.stream()
                .map(n -> n * 2)  // Function to double the numbers
                .filter(n -> n % 3 == 0)  // Predicate to only return multiples of 3
                .collect(Collectors.toSet());  // Convert stream to a Set
        System.out.println(nums);
    }
}
