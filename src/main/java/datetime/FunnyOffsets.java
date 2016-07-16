package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

/*
 * Alternative equivalent sorts:
 * .sorted((zoneId1, zoneId2) ->
 *      (int) Duration.between(now.atZone(zoneId1), now.atZone(zoneId2)).getSeconds())
 *  -- or --
 * .sorted((zoneId1, zoneId2) ->
 *      (int) ChronoUnit.MINUTES.between(now.atZone(zoneId1), now.atZone(zoneId2))
 */
public class FunnyOffsets {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        List<ZoneId> zoneIds = ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .filter(zoneId -> {
                    ZoneOffset offset = now.atZone(zoneId).getOffset();
                    return offset.getTotalSeconds() % (60 * 60) != 0;
                })
                .sorted(comparingInt(zoneId ->
                        now.atZone(zoneId).getOffset().getTotalSeconds()))
                .collect(toList());

        ZonedDateTime current = now.atZone(ZoneId.systemDefault());
        System.out.println("Current time is " + current);
        System.out.printf("%10s %20s %13s%n", "Offset", "ZoneId", "Time");
        zoneIds.forEach(zoneId -> {
            ZonedDateTime zdt = current.withZoneSameInstant(zoneId);
            System.out.printf("%10s %25s %10s%n", zdt.getOffset(), zoneId,
                    zdt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        });
    }
}
