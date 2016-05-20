import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ImplementConsumer {
    public static void main(String[] args) {
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer x) {
                        System.out.println(x);
                    }
                });

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
