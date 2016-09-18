package streams;

import java.util.stream.IntStream;

/**
 * Created by Ken Kousen on 8/5/16.
 */
public class PeekDemo {
    public static int doubleIt(int x) {
        return x * 2;
    }

    public static void main(String[] args) {
        int total = IntStream.rangeClosed(1, 10)
                .peek(n -> System.out.println("Before: " + n))
                .map(PeekDemo::doubleIt)
                .peek(n -> System.out.println("After : " + n))
                .sum();

        System.out.printf("The total is %d%n", total);
    }
}
