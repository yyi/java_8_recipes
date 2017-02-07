package optionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalDemo {

    private List<String> strings = new ArrayList<>();

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Optional<String> findFirst(Predicate<String> predicate) {
        return strings.stream()
                .filter(predicate)
                .findFirst();
    }

    public static <T> Optional<T> createOptionalTheHardWay(T value) {
        return value == null ? Optional.empty() : Optional.of(value);
    }

    public static <T> Optional<T> createOptionalTheEasyWay(T value) {
        return Optional.ofNullable(value);
    }
}
