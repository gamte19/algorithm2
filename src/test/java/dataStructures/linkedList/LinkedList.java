package dataStructures.linkedList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedList {
    data_structures.linked_list.LinkedList<String> fruits = new data_structures.linked_list.LinkedList<String>();

    @Before
    public void setUp() {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("Pear");
        fruits.add("Strawberry");
    }

    @After
    public void tearDown() {
        fruits = null;
    }

    @Test
    public void getSize() {
        assertEquals(5, fruits.size());
    }

    @Test
    public void getValueByIndex() {
        assertEquals("Banana", fruits.getByIndex(1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void indexIsHigherThanSize() {
        fruits.getByIndex(10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void indexIsSmalerThanSize() {
        fruits.getByIndex(-1);
    }

    @Test
    public void insertByIndexSize() {
        assertEquals(6, fruits.size());
    }

    @Test
    public void insertedDataIsInPosition() {
        assertNotEquals(fruits.getByIndex(2), "mulberry");
        fruits.insert(2, "mulberry");
        assertEquals(fruits.getByIndex(2), "mulberry");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void indexIsHigherThanSizeWhenInsertNewData() {
        fruits.getByIndex(10);
    }

    @Test
    public void removeDataByIndex() {
        assertEquals(fruits.size(), 5);
        assertEquals(fruits.getByIndex(1), "Banana");
        fruits.remove(1);
        assertEquals(fruits.size(), 4);
        assertEquals(fruits.getByIndex(1), "Pineapple");
    }
}
