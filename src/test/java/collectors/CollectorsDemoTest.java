package collectors;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectorsDemoTest {
    private CollectorsDemo demo = new CollectorsDemo();

    @Test
    public void createList() throws Exception {
        List<String> nameList = demo.createList();
        assertEquals(7, nameList.size());
        assertEquals(ArrayList.class, nameList.getClass());
    }

    @Test
    public void createSet() throws Exception {
        Set<String> nameSet = demo.createSet();
        assertEquals(6, nameSet.size());
        assertEquals(HashSet.class, nameSet.getClass());
    }

    @Test
    public void createDeque() throws Exception {
        Deque<String> nameDeque = demo.createDeque();
        assertEquals(7, nameDeque.size());
        assertEquals(ArrayDeque.class, nameDeque.getClass());
    }

    @Test
    public void createArray() throws Exception {
        String[] names = demo.createArray();
        assertEquals(4, names.length);
    }

    @Test
    public void evenLengthStrings() throws Exception {
        List<String> evenLengthStrings =
                demo.evenLengthStrings("here", "are", "a", "few", "strings");
        evenLengthStrings.forEach(s -> {
            assertTrue(s.length() % 2 == 0);
        });
    }

    @Test
    public void evenLengthStringSet() throws Exception {
        SortedSet<String> stringSet = demo.oddLengthStringSet("here", "are", "a", "few", "strings");
        System.out.println(stringSet);
        stringSet.forEach(s -> assertTrue(s.length() % 2 != 0));
        stringSet.first().equals("a");
        stringSet.last().equals("strings");
    }
}