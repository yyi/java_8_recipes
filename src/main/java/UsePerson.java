import java.util.*;
import java.util.stream.Collectors;

public class UsePerson {
    private List<String> names =
            Arrays.asList("Joffrey Baratheon", "Daenerys Targaryen", "Jon Snow",
                    "Arya Stark", "Tyrion Lannister", "Margaery Tyrell");

    public List<Person> createPersonListJava7() {
        List<Person> people = new ArrayList<>();
        for (String name : names) {
            people.add(new Person(name));
        }
        return people;
    }

    public List<Person> createPersonList() {
        return names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());
    }

    public List<Person> createPersonListUsingCtorRef() {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public Deque<Person> createPersonDeque() {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public Person[] createPersonArray() {
        return names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }

    public List<Person> createPersonListUsingNew() {
        return names.stream()
                .map(Person::new)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void main(String[] args) {
        UsePerson up = new UsePerson();
        System.out.println(up.createPersonList());
        System.out.println(up.createPersonListUsingNew());
        System.out.println(up.createPersonDeque());
        Arrays.stream(up.createPersonArray())
                .forEach(System.out::println);
    }
}
