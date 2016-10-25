import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class Summarizing {
    public static void main(String[] args) {
        DoubleSummaryStatistics stats = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();

        System.out.println(stats);
    }
}
