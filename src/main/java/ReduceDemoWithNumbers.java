import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReduceDemoWithNumbers {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10)
                .reduce(0, (acc, n) -> {
                    System.out.printf("Acc=%d, n=%d%n", acc, n);
                    return acc + 2 * n;
                });
        System.out.println(sum);
    }
}
