package mapvsflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        /*
        List<String> lines = Arrays.asList("this is a sentence", "", "this is another one",
                "here is one with lots of words", "one", "word");

        lines.stream()
                .map(line -> line.split("\\W+"))
                .forEach(array -> System.out.println(Arrays.asList(array)));

        lines.stream()
                .map(line -> line.split("\\W+"))
                .map(Arrays::stream)
                .forEach(stream -> System.out.println(stream.collect(Collectors.toList())));

        lines.stream()
                .map(line -> line.split("\\W+"))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
*/
        Customer sheridan = new Customer("Sheridan");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");

        sheridan.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));
        ivanova.addOrder(new Order(4))
                .addOrder(new Order(5));

        List<Customer> customers = Arrays.asList(sheridan, ivanova, garibaldi);

        // map for 1-1 customer to name --> Stream<String>
        customers.stream()
                .map(Customer::getName)
                .forEach(System.out::println);

        // map 1-many customer to orders --> Stream<List<Order>)
        customers.stream()
                .map(Customer::getOrders)
                .forEach(System.out::println);

        // map 1-many customer to orders.stream() --> Stream<Stream<Order>>
        customers.stream()
                .map(customer -> customer.getOrders().stream())
                .forEach(System.out::println);

        // flatMap 1-many customer to orders.stream() --> Stream<Order>
        customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .forEach(System.out::println);
    }
}
