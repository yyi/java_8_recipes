import java.util.stream.IntStream;

public class Primes {
    public boolean isPrime(int num) {
        if (num == 2) return true;
        int limit = (int) (Math.sqrt(num) + 1);
        return num > 1 && IntStream.rangeClosed(2, limit)
                .noneMatch(divisor -> num % divisor == 0);
    }

    public int nextPrime(int num) {
        return IntStream.iterate(num + 1, n -> n + 1)
                .filter(this::isPrime)
                .findFirst()
                .getAsInt();
    }
}
