import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        Integer doubleSum = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(0, (acc, n) -> {
                    System.out.printf("acc=%d, n=%d%n", acc, n);
                    return acc + 2 * n;
                });
        System.out.println(doubleSum);
    }
}
