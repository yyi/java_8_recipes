package mapvsflatmap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

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