import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ReduceProduct {
    public static void main(String[] args) {
//        OptionalLong product = LongStream.rangeClosed(1, 10)
//                .reduce((acc, n) -> acc * n);

        long productOptional = LongStream.rangeClosed(1, 10)
                .reduce((acc, n) -> {
                    System.out.println("acc=" + acc + ", n=" + n);
                    return acc * n * 2;
                }).orElse(0);
        System.out.println(productOptional);

        long product = LongStream.rangeClosed(1, 10)
                .reduce(1, (acc, n) -> {
                    System.out.printf("acc=%d, n=%d%n", acc, n);
                    return acc * n * 2;
                });
        System.out.println(product);
    }
}
