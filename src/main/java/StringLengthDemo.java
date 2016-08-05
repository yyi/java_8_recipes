import java.util.stream.Stream;

/**
 * Created by Ken Kousen on 7/20/16.
 */
public class StringLengthDemo {
    public static void main(String[] args) {
        int sum = Stream.of("this", "is", "a", "stream", "of", "strings")
                .mapToInt(String::length)
                .sum();
        System.out.printf("The sum of the lengths is %d%n", sum);
    }
}
