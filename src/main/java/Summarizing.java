import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class Summarizing {
    public static void main(String[] args) {
//        double sum = DoubleStream.generate(Math::random)
//                .limit(1_000_000)
//                .sum();
//        System.out.println(sum);

        DoubleSummaryStatistics stats =
                DoubleStream.generate(Math::random)
                        .limit(10)
//                      .filter(n -> n <= 0.5)
                        //.peek(System.out::println)
//                        .map(num -> {
//                            System.out.println(num);
//                            return num;
//                        })
                        .summaryStatistics();
        System.out.println(stats);
    }
}
