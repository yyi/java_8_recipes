package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class ProcessDictionary {
    public static void main(String[] args) throws Exception {
        try (Stream<String> lines =
                     Files.lines(Paths.get("/", "usr", "share", "dict", "web2"))) {
            lines.filter(s -> s.length() > 10)
                    .map(String::toLowerCase)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(10)
                    .forEach(w ->
                            System.out.printf("%s (%d)%n", w, w.length()));
        }  // Stream implements AutoCloseable

/*
        Optional<String> max = Files.lines(
                Paths.get("/", "usr", "share", "dict", "web2"))
                // .filter(s -> s.length() > 10)
                .map(String::toLowerCase)
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst();

        System.out.println(max.isPresent() ? max.get() : max.orElse("None found"));
        System.out.println(max.orElseGet(() -> "nothing"));
        System.out.println(max.orElse("nothing")); */
    }
}
