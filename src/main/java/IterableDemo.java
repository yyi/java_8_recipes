import java.util.Arrays;
import java.util.List;

public class IterableDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);
        nums.forEach(System.out::println);
    }
}
