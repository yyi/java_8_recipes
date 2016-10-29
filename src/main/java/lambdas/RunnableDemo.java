package lambdas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RunnableDemo {
    public static void main(String[] args) {

        // Use in Java 7 or earlier:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("inside Thread constructor as arg")).start();

        Runnable r = () -> System.out.println("inside runnable using a lambda");
        new Thread(r).start();
    }

}
