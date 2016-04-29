import java.util.concurrent.atomic.AtomicInteger;

public class ParallelDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        System.out.println(ai);
        System.out.println(ai.getAndIncrement());
    }
}
