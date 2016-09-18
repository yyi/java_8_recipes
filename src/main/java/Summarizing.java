import com.sun.tools.doclint.Entity;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static com.sun.tools.doclint.Entity.sum;

public class Summarizing {
    public static void main(String[] args) {
        double sum = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .sum();
        System.out.println(sum);

        DoubleSummaryStatistics stats =
                DoubleStream.generate(Math::random)
                .limit(10_000)
//                .filter(n -> n <= 0.5)
                //.peek(System.out::println)
                .summaryStatistics();
        System.out.println(stats);
    }
}
