package concurrency;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CompletableFutureTests {

    @Test(expected = CancellationException.class)
    public void joinAfterCancel() throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.cancel(false);
        future.complete("I'm done");
        System.out.println(future.join());
    }

    @Test
    public void completeWithGet() throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        boolean finished = future.complete("I'm done");
        assertTrue(finished);
        try {
            assertEquals("I'm done", future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void completeWithJoin() throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        boolean finished = future.complete("I'm done");
        assertTrue(finished);
        assertEquals("I'm done", future.join());
    }

    @Test(expected = ExecutionException.class)
    public void completeExceptionally() throws Exception {
        parseNumber("abc").get();
    }

    @Test
    public void completeExceptionallyWithCause() throws Exception {
        try {
            parseNumber("abc").get();
            fail("Should not get here");
        } catch (Exception e) {
            assertEquals(ExecutionException.class, e.getClass());
            assertEquals(NumberFormatException.class, e.getCause().getClass());
        }
    }

    @Test
    public void completeLong() throws Exception {
        assertTrue(parseNumber("42").get() == 42);
    }

    private CompletableFuture<Long> parseNumber(String arg) {
        CompletableFuture<Long> future = new CompletableFuture<>();
        try {
            future.complete(Long.parseLong(arg));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    @Test
    public void supplyThenAccept() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        CompletableFuture.supplyAsync(() -> "42")
                .thenApply(Integer::parseInt)
                .thenApply(x -> 2 * x)
                .thenAccept(System.out::println);
        System.out.println("Running...");

        String result = baos.toString();
        assertEquals("84\nRunning...\n", result);
        assertTrue(result.contains("84"));
        assertTrue(result.contains("Running..."));
    }
}
