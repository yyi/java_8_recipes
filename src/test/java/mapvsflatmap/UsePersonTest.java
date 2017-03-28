package mapvsflatmap;

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

    @Before
    public void setUp() {
        people = up.getNames().stream()
                .map(Person::new)
                .toArray(Person[]::new);
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
    public void copyConstructor() throws Exception {
        Person before = new Person("Grace Hopper");

        List<Person> people = Stream.of(before)
                .collect(Collectors.toList());
        Person after = people.get(0);

        assertTrue(before == after);  // same object

        before.setName("Grace Murray Hopper");
        assertEquals("Grace Murray Hopper", after.getName());

        people = Stream.of(before)
                .map(Person::new)
                .collect(Collectors.toList());
        after = people.get(0);
        assertFalse(before == after);  // different objects
        assertEquals(before, after);   // but equivalent

        before.setName("Rear Admiral Dr. Grace Murray Hopper");
        assertFalse(before.equals(after));
    }

    @Test
    public void varargsConstructor() throws Exception {
        List<Person> persons = Arrays.stream(people)
                .map(Person::getName)          // Stream<String>
                .map(name -> name.split(" "))  // Stream<String[]>
                .map(Person::new)              // Stream<Person> using String... ctor
                .collect(Collectors.toList());
        assertThat(persons, containsInAnyOrder(people));
    }

    @Test
    public void createPersonLinkedList() throws Exception {
        assertThat(up.createPersonLinkedList(), containsInAnyOrder(people));
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