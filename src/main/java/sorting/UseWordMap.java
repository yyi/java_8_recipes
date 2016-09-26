package sorting;

import java.util.Map;

import static java.util.Comparator.reverseOrder;

public class UseWordMap {
    public static void main(String[] args) {
        WordMap wordMap = new WordMap();
        wordMap.setFileName("function_package.txt");
        Map<String, Long> map = wordMap.createWordMap();

        System.out.printf("Top 10 word counts for %s:%n", wordMap.getFileName());
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .limit(10)
                .forEach(System.out::println);
    }
}
