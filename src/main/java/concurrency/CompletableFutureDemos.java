package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CompletableFutureDemos {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Map<Integer, Product> cache = new ConcurrentHashMap<>();

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

    private Product getLocal(int id) {
        return cache.get(id);
    }

    private Product getRemote(int id) {
        try {
            Thread.sleep(100);
            if (id == 666) {
                throw new RuntimeException("Evil request");
            }
        } catch (InterruptedException ignored) {
        }
        return new Product(id, "name");
    }

    public CompletableFuture<Product> getProduct(int id) {
        try {
            Product product = getLocal(id);
            if (product != null) {
                logger.info("getLocal with id=" + id);
                return CompletableFuture.completedFuture(product);
            } else {
                // Synchronous (simulating legacy system)
                logger.info("getRemote with id=" + id);
                CompletableFuture<Product> future = new CompletableFuture<>();
                Product p = getRemote(id);
                cache.put(id, p);
                future.complete(p);
                return future;
            }
        } catch (Exception e) {
            logger.info("exception thrown");
            CompletableFuture<Product> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public CompletableFuture<Product> getProductAsync(int id) {
        try {
            Product product = getLocal(id);
            if (product != null) {
                logger.info("getLocal with id=" + id);
                return CompletableFuture.completedFuture(product);
            } else {
                logger.info("getRemote with id=" + id);
                // Asynchronous
                return CompletableFuture.supplyAsync(() -> {
                    Product p = getRemote(id);
                    cache.put(id, p);
                    return p;
                });
            }
        } catch (Exception e) {
            logger.info("exception thrown");
            CompletableFuture<Product> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static void main(String[] args) {
        CompletableFutureDemos.supplyThenAccept();

        ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.SECONDS);
    }

}
