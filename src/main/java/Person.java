import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    private Logger logger = Logger.getLogger(Person.class.getName());
    private String name;

    public Person() {
        logger.info(() -> "Default ctor");
    }

    public Person(String name) {
        logger.info(() -> "One arg ctor with: " + name);
        this.name = name;
    }

    public Person(String... names) {
        logger.info(() -> "Varagrs ctor with: " + names.length + " args, " + Arrays.asList(names));
        name = Arrays.stream(names)
                .collect(Collectors.joining(" "));
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return String.format("Person(%s)", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
