import java.util.stream.Stream;

public class Miscellaneous {

    public static int multByTwo(int n) {
        System.out.printf("Inside multByTwo with arg %d%n", n);
        return n * 2;
    }

    public static void main(String[] args) {
        int firstEvenDivBy3 = Stream.of(3, 1, 4, 1, 5, 9)
                .mapToInt(Miscellaneous::multByTwo)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .getAsInt();
        System.out.printf("First even divisible by 3 is %d%n", firstEvenDivBy3);
    }
}
