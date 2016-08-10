package datetime;

import java.time.*;

public class NowFactoryMethod {
    public static void main(String[] args) {
        System.out.println("Instant.now():       " + Instant.now());
        System.out.println("LocalDate.now():     " + LocalDate.now());
        System.out.println("LocalTime.now():     " + LocalTime.now());
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
        System.out.println("ZonedDateTime.now(): " + ZonedDateTime.now());
    }
}
