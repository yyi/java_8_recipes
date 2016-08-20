import java.util.stream.Stream;

/**
 * Created by Ken Kousen on 8/19/16.
 */
public class Bad {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .peek(System.out::println)
                .count();
    }
}
