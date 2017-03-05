package mapvsflatmap;

import mapvsflatmap.Person;

import java.util.*;
import java.util.stream.Collectors;

public class UsePerson {
    private static List<String> names =
            Arrays.asList("Joffrey Baratheon", "Daenerys Targaryen", "Jon Snow",
                    "Arya Stark", "Tyrion Lannister", "Margaery Tyrell");

    public List<String> getNames() {
        return names;
    }

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

    public List<Person> createPersonList_CtorRef() {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public List<Person> createPersonList_2ArgCtrRef() {
        return names.stream()                  // Stream<String>
                .map(name -> name.split(" "))  // Stream<String[]>
                .map(Person::new)              // Stream<Person> using String... ctor
                .map(Person::new)              // Stream<Person> with copies
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

}
