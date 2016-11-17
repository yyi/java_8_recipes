import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class UsePersonTest {
    private UsePerson up = new UsePerson();
    private Person[] people;
    private List<String> names;

    @Before
    public void setUp() {
        names = up.getNames();
        people = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }

    @Test
    public void testPersonCtor() throws Exception {
        new Person("Spock");
        new Person("James", "Kirk");
        new Person("Leonard McCoy".split(" "));
        Stream.of("Montgomery Scott", "Pavel Chekov", "Hikaru Sulu")
                .map(name -> name.split(" "))
                .map(Person::new)
                .forEach(System.out::println);
    }

    @Test
    public void createPersonListJava7() throws Exception {
        assertThat(up.createPersonListJava7(), containsInAnyOrder(people));
    }

    @Test
    public void createPersonList() throws Exception {
        assertThat(up.createPersonList(), containsInAnyOrder(people));
    }

    @Test
    public void createPersonList_CtorRef() throws Exception {
        assertThat(up.createPersonList_CtorRef(), containsInAnyOrder(people));
    }

    @Test
    public void createPersonList_2ArgCtrRef() throws Exception {
        assertThat(up.createPersonList_2ArgCtrRef(), containsInAnyOrder(people));
    }

    @Test
    public void createPersonDeque() throws Exception {
        assertThat(up.createPersonDeque(), containsInAnyOrder(people));
    }

    @Test
    public void createPersonArray() throws Exception {
        assertThat(Arrays.asList(up.createPersonArray()), containsInAnyOrder(people));
    }

    @Test
    public void createPersonListUsingNew() throws Exception {
        assertThat(up.createPersonListUsingNew(), containsInAnyOrder(people));
    }

}