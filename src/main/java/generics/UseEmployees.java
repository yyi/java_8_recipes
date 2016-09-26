package generics;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class UseEmployees {
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    public void printEmployees(Employee[] emps) {
        Stream.of(emps).forEach(System.out::println);
    }

    public void printAllTrue(Object[] employees, Predicate<Object> predicate) {
        Arrays.stream(employees)
                .filter(predicate)
                .forEach(System.out::println);
    }

    public void printEmployees(List<? extends Employee> emps) {
        // emps.add(new Hourly(4, "Milton Waddams", 100.0, 50.0));
        emps.forEach(e -> System.out.printf(String.format("%s makes %s%n",
                e.getName(), nf.format(e.getPay()))));
    }

    public Salaried[] createSalariedEmployees() {
        return new Salaried[]{
                new Salaried(1, "Peter Gibbons", 75000.0),
                new Salaried(2, "Samir Nagheenanajar", 60000.0),
                new Salaried(3, "Michael Bolton", 65000.0)
        };
    }

    public Hourly[] createHourlyEmployees() {
        return new Hourly[]{
                new Hourly(4, "Danny Ocean", 100, 40),
                new Hourly(5, "Rusty Ryan", 100, 40),
                new Hourly(6, "Linus Caldwell", 75, 40)
        };
    }

    public Temp[] createTempEmployees() {
        return new Temp[]{
                new Temp(7, "Virgil Malloy", 80, 40),
                new Temp(8, "Turk Malloy", 80, 40),
                new Temp(9, "Livingston Dell", 80, 40),
                new Temp(10, "Yen", 75, 40),
                new Temp(11, "Frank Catton", 80, 40),
                new Temp(12, "Saul Bloom", 90, 40),
                new Temp(13, "Basher Tarr", 80, 40)
        };
    }

    public static void main(String[] args) {
        UseEmployees demo = new UseEmployees();
        Salaried[] emps = demo.createSalariedEmployees();

        demo.printEmployees(emps);

        List<Salaried> salarieds = Arrays.asList(emps);
        demo.printEmployees(salarieds);

        // demo.printAllTrue(emps, e -> e.getPay() > 2000);

        demo.printAllTrue(emps, e -> e.toString().length() % 2 == 0);
    }
}
