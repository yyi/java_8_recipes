public class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Person(name:%s)", name);
    }
}
