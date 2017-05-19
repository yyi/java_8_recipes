package datetime;

import java.time.Duration;
import java.time.Instant;

public class Timer {
    public static double getTiming(Instant start, Instant end) {
        return Duration.between(start, end).toMillis() / 1000.0;
    }
}
