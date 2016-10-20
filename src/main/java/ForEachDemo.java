import java.util.Arrays;
import java.util.List;

/**
 * Created by Ken Kousen on 10/14/16.
 */
public class ForEachDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("This", "is", "a", "list", "of", "strings");
        strings.forEach(System.out::println);
    }
}
