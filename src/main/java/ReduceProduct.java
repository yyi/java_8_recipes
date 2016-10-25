import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ReduceProduct {
    public static void main(String[] args) {
        long product = LongStream.rangeClosed(1, 10)
                .reduce(1, (acc, n) -> {
                    System.out.printf("acc=%d, n=%d%n", acc, n);
                    return acc * n * 2;
                });
        System.out.println(product);
    }
}
