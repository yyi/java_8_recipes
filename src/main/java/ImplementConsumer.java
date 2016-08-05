import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ImplementConsumer {
    public static void main(String[] args) {
        IntStream.of(3, 1, 4, 1, 5, 9)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int x) {
                        System.out.println(x);
                    }
                });

        IntStream.of(3, 1, 4, 1, 5, 9)
                .forEach(n -> System.out.println(n));

        IntStream.of(3, 1, 4, 1, 5, 9)
                .forEach(System.out::println);

        IntConsumer tryCatchBlock = x -> {
            try {
                throw new Exception("invalid");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        IntStream.of(3, 1, 4, 1, 5, 9)
                .forEach(tryCatchBlock);
    }
}
