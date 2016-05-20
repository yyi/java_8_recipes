import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RunnableDemo {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("inside runnable using a lambda");
        new Thread(r).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("inside Thread as arg")).start();

        ExecutorService service = Executors.newFixedThreadPool(4);
        IntStream.range(0, 10)
                .forEach(n -> {
                    service.submit(() ->
                            System.out.printf("executor service with %d%n", n));
                });

        service.shutdown();
    }

}
