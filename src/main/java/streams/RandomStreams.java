package streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by Ken Kousen on 8/13/16.
 */
public class RandomStreams {
    public static final int LIMIT = 10;

    public static void main(String[] args) {
        DoubleSummaryStatistics stats =
                Stream.iterate(BigDecimal.ONE,
                        b -> b.add(BigDecimal.ONE))
                .limit(1_000_000)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();
        System.out.println(stats);

        String[] strings = "This is a stream of strings".split(" ");
        Map<Integer, List<String>> map = Arrays.stream(strings)
                .collect(Collectors.groupingBy(String::length));
        map.forEach((k,v) -> System.out.printf("%d: %s%n", k, v));

        Map<Boolean, List<String>> evens = Arrays.stream(strings)
                .collect(partitioningBy(s -> s.length() % 2 == 0));
        evens.forEach((k,v) -> System.out.println(k + ": " + v));

/*
        Random r = new Random();
        r.ints()
                .limit(LIMIT)
                .sorted()
                .forEach(System.out::println);

        r.doubles()
                .limit(LIMIT)
                .filter(x -> x < 0.5)
                .sorted()
                .forEach(System.out::println);

        List<String> longs = r.longs()
                .limit(LIMIT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());

        List<Integer> listOfInts = r.ints()
                .limit(LIMIT)
//                .collect(Collectors.toList());
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
                */
    }
}
