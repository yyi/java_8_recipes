package collectors;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {
    public List<String> createList() {
        return Stream.of("Mr. Furious", "The Blue Raja", "The Shoveler", "The Bowler",
                "Invisible Boy", "The Spleen", "The Sphinx")
                .collect(Collectors.toList());
    }

    public Set<String> createSet() {
        return Stream.of("Casanova Frankenstein", "The Disco Boys", "The Not-So-Goodie Mob",
                "The Suits", "The Suzies", "The Furriers", "The Furriers")
                .collect(Collectors.toSet());
    }

    public Deque<String> createDeque() {
        return Stream.of("Hank Azaria", "Janeane Garofalo", "William H. Macy",
                "Paul Reubens", "Ben Stiller", "Kel Mitchell", "Wes Studi")
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public String[] createArray() {
        return Stream.of("Waffler", "Pencilhead", "Reverse Psychologist", "PMS Avenger")
                .toArray(String[]::new);
    }

    public List<String> evenLengthStrings(String... strings) {
        return Stream.of(strings)
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());
    }
}
