package Izziv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    private BST<Integer> tree;

    @BeforeEach
    void setUp() {
        this.tree = new BST<>();
    }

    @Test
    void insert() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
    }

    @Test
    void insertException() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertThrows(InputMismatchException.class, () -> this.tree.insert(1));
    }

    @Test
    void delete() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        this.tree.delete(2);
        assertEquals(2, this.tree.size());
    }

    @Test
    void deleteException() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertThrows(NoSuchElementException.class, () -> this.tree.delete(4));
    }

    @Test
    void deleteEmpty() {
        assertThrows(EmptyStackException.class, () -> this.tree.delete(1));
    }

    @Test
    void deleteDeleted() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        this.tree.delete(2);
        assertEquals(2, this.tree.size());
        assertThrows(NoSuchElementException.class, () -> this.tree.delete(2));
    }

    @Test
    void memberTrue() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertTrue(this.tree.member(2));
    }

    @Test
    void memberFalse() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertFalse(this.tree.member(4));
    }

    @Test
    void memberEmpty() {
        assertThrows(EmptyStackException.class, () -> this.tree.member(1));
    }

    @Test
    void memberDeleted() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertTrue(this.tree.member(2));
        this.tree.delete(2);
        assertFalse(this.tree.member(2));
    }

    @Test
    void size() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertEquals(3, this.tree.size());
    }

    @Test
    void sizeEmpty() {
        assertEquals(0, this.tree.size());
    }

    @Test
    void sizeDeleted() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        this.tree.delete(2);
        this.tree.insert(4);
        this.tree.delete(3);
        assertEquals(2, this.tree.size());
    }

    @Test
    void depth() {
        this.tree.insert(1);
        this.tree.insert(2);
        this.tree.insert(3);
        assertEquals(3, this.tree.depth());
    }

    @Test
    void depthEmpty() {
        assertEquals(0, this.tree.depth());
    }

    @Test
    void depthDeleted() {
        this.tree.insert(1);
        System.out.println();
        this.tree.insert(2);
        System.out.println();
        this.tree.insert(3);
        System.out.println();
        this.tree.delete(2);
        System.out.println();
        this.tree.insert(4);
        System.out.println();
        this.tree.delete(3);
        System.out.println();
        assertEquals(2, this.tree.depth());
    }

    @Test
    void depthWide() {
        int[] a = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i : a) {
            this.tree.insert(i);
        }
        assertEquals(4, this.tree.depth());
    }

    @Test
    void add() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
    }

    @Test
    void addException() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        assertThrows(InputMismatchException.class, () -> this.tree.add(1));
    }

    @Test
    void removeFirst() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        assertEquals(1, this.tree.removeFirst());
    }

    @Test
    void removeFirstMultiple() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.add(4);
        assertEquals(1, this.tree.removeFirst());
        assertEquals(2, this.tree.removeFirst());
    }

    @Test
    void removeFirstEmpty() {
        assertThrows(EmptyStackException.class, () -> this.tree.removeFirst());
    }

    @Test
    void removeFirstTreeMultiple() {
        int[] a = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i : a) {
            this.tree.add(i);
        }
        assertEquals(8, this.tree.removeFirst());
        assertEquals(9, this.tree.removeFirst());
        assertEquals(10, this.tree.removeFirst());
        assertEquals(11, this.tree.removeFirst());
        assertEquals(12, this.tree.removeFirst());
        assertEquals(13, this.tree.removeFirst());
        assertEquals(14, this.tree.removeFirst());
        assertEquals(15, this.tree.removeFirst());
        assertEquals(4, this.tree.removeFirst());
        assertEquals(5, this.tree.removeFirst());
        assertEquals(6, this.tree.removeFirst());
        assertEquals(7, this.tree.removeFirst());
        assertEquals(2, this.tree.removeFirst());
        assertEquals(3, this.tree.removeFirst());
        assertEquals(1, this.tree.removeFirst());
        assertThrows(EmptyStackException.class, () -> this.tree.removeFirst());
    }

    @Test
    void getFirst() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        assertEquals(1, this.tree.getFirst());
    }

    @Test
    void getFirstEmpty() {
        assertThrows(EmptyStackException.class, () -> this.tree.getFirst());
    }

    @Test
    void getFirstDelete() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.add(4);
        assertEquals(1, this.tree.getFirst());
        this.tree.delete(2);
        assertEquals(1, this.tree.getFirst());
        this.tree.delete(1);
        assertEquals(3, this.tree.getFirst());
    }

    @Test
    void isEmptyEmpty() {
        assertTrue(this.tree.isEmpty());
    }

    @Test
    void isEmptyNotEmpty() {
        this.tree.add(1);
        assertFalse(this.tree.isEmpty());
    }

    @Test
    void isEmptyDeleted() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.delete(2);
        assertFalse(this.tree.isEmpty());
    }

    @Test
    void isEmptyDeletedTillEmpty() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.delete(2);
        this.tree.delete(1);
        assertFalse(this.tree.isEmpty());
        this.tree.delete(3);
        assertTrue(this.tree.isEmpty());
    }

    @Test
    void remove() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.add(4);
        this.tree.remove(3);
        assertEquals(3, this.tree.size());
        assertEquals(1, this.tree.getFirst());
        this.tree.remove(1);
        assertEquals(2, this.tree.getFirst());
        this.tree.remove(2);
        assertEquals(4, this.tree.getFirst());
        this.tree.remove(4);
        assertThrows(EmptyStackException.class, () -> this.tree.remove(2));
    }

    @Test
    void removeException() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.add(4);
        assertThrows(NoSuchElementException.class, () -> this.tree.remove(5));
    }

    @Test
    void removeEmpty() {
        assertThrows(EmptyStackException.class, () -> this.tree.remove(1));
    }

    @Test
    void existsTrue() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        assertTrue(this.tree.exists(3));
    }

    @Test
    void existsFalse() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        assertFalse(this.tree.exists(4));
    }

    @Test
    void existsEmpty() {
        assertThrows(EmptyStackException.class, () -> this.tree.exists(1));
    }

    @Test
    void existsDeleted() {
        this.tree.add(1);
        this.tree.add(2);
        this.tree.add(3);
        this.tree.delete(2);
        assertFalse(this.tree.exists(2));
    }


}