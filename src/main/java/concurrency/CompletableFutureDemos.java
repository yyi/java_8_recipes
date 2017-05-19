package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemos {

    public static void supplyThenAccept() {
        CompletableFuture.supplyAsync(CompletableFutureDemos::sleepThenReturnString)
                .thenApply(Integer::parseInt)
                .thenApply(x -> 2 * x)
                .thenAccept(System.out::println);
        System.out.println("Running...");
    }

    private static String sleepThenReturnString() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return "42";
    }

    public static void main(String[] args) {
        CompletableFutureDemos.supplyThenAccept();

        ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.SECONDS);
    }

}
