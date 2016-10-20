package fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessDictionary {
    private Path dictionary = Paths.get("/usr/share/dict/words");

    public void printTenLongestWords() {
        System.out.println("\nTen Longest Words:");
        try (Stream<String> lines = Files.lines(dictionary)) {
            lines.filter(s -> s.length() > 20)
                    .map(String::toLowerCase)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(10)
                    .forEach(w ->
                            System.out.printf("%s (%d)%n", w, w.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHowManyWordsOfEachLength() {
        System.out.println("\nNumber of words of each length:");
        try (Stream<String> lines = Files.lines(dictionary)) {
            lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(
                            String::length, Collectors.counting()))
                    .forEach((len, num) -> System.out.printf("%d: %d%n", len, num));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSortedMapOfWords() {
        System.out.println("\nNumber of words of each length (desc order):");
        try (Stream<String> lines = Files.lines(dictionary)) {
            Map<Integer, Long> map = lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(
                            String::length, Collectors.counting()));

            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("Length %d: %d words%n", e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ProcessDictionary processDictionary = new ProcessDictionary();
        processDictionary.printTenLongestWords();
        processDictionary.printHowManyWordsOfEachLength();
        processDictionary.printSortedMapOfWords();
    }
}
