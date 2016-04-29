import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.stream.Stream;

public class UseFileFilter {
    public static void main(String[] args) {
        File directory = new File("./src/main/java");
        System.out.println(directory.getAbsolutePath());

        // Anonymous inner class
        Stream.of(directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");
            }
        })).forEach(System.out::println);

        // Use lambda expression instead
        Stream.of(
                directory.list((dir, name) -> name.endsWith("java")))
                .forEach(System.out::println);

        // Assign lambda to variable
        FilenameFilter javaFiles = (dir, name) -> name.endsWith("java");
        Stream.of(
                directory.list(javaFiles))
                .forEach(System.out::println);
    }
}
