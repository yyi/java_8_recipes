package juf_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImplementPredicate {

    public String getNames(String... names) {
        return Arrays.stream(names)
                .collect(Collectors.joining(", "));
    }

    public String getNamesOfLength5(String... names) {
        return Arrays.stream(names)
                .filter(s -> s.length() == 5)
                .collect(Collectors.joining(", "));
    }

    public String getNamesStartingWithS(String... names) {
        return Arrays.stream(names)
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.joining(", "));
    }

    public String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }
}
