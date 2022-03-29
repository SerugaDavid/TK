package Izziv3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PrioritetnaVrstaTest {

    private PrioritetnaVrsta<String> pv;

    @BeforeEach
    void setUp() {
        pv = new PrioritetnaVrsta<>(10);
    }

    @AfterEach
    void tearDown() {
    }

    /** Test metod razreda <PrioritetnaVrsta> */

    // testi dodajanja

    @Test
    void testAddOne() {
        pv.add("Test");
    }

    @Test
    void testAddMultiple() {
        pv.add("Test1");
        pv.add("Test2");
    }

    @Test
    void testAddOverflow() {
        pv = new PrioritetnaVrsta<>(2);
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
    }

    // testi brisanja

    @Test
    void testRemoveFirstEmpty() {
        NoSuchElementException thrown = assertThrows(
                NoSuchElementException.class,
                () -> pv.removeFirst(),
                "Pričakovana napaka"
        );
    }

    @Test
    void testRemoveFirstOne() {
        pv.add("Test");
        assertEquals("Test", pv.removeFirst());
    }

    @Test
    void testRemoveFirstMultiple() {
        pv.add("Test1");
        pv.add("Test5");
        pv.add("Test2");
        pv.add("Test4");
        pv.add("Test3");
        System.out.println("----------");
        assertEquals("Test5", pv.removeFirst());
        assertEquals("Test4", pv.removeFirst());
        assertEquals("Test3", pv.removeFirst());
        assertEquals("Test2", pv.removeFirst());
        assertEquals("Test1", pv.removeFirst());
    }

    // metoda get

    @Test
    void testGetFirstEmpty() {
        NoSuchElementException thrown = assertThrows(
                NoSuchElementException.class,
                () -> pv.getFirst(),
                "Pričakovana napaka"
        );
    }

    @Test
    void testGetFirstOne() {
        pv.add("Test");
        assertEquals("Test", pv.getFirst());
    }

    @Test
    void testGetFirstMultiple() {
        pv.add("Test1");
        assertEquals("Test1", pv.getFirst());
        pv.add("Test3");
        pv.add("Test2");
        assertEquals("Test3", pv.getFirst());
        assertEquals("Test3", pv.getFirst());
    }

    // testiranje metode za globino

    @Test
    void testDepthEmpty() {
        assertEquals(0, pv.depth());
    }

    @Test
    void testDepthOne() {
        pv.add("Test1");
        assertEquals(1, pv.depth());
    }

    @Test
    void testDepthMultiple() {
        pv.add("Test1");
        assertEquals(1, pv.depth());
        pv.add("Test5");
        assertEquals(2, pv.depth());
        pv.add("Test2");
        assertEquals(2, pv.depth());
        pv.add("Test4");
        assertEquals(3, pv.depth());
        pv.add("Test3");
        assertEquals(3, pv.depth());
        pv.add("Test6");
        assertEquals(3, pv.depth());
        pv.add("Test8");
        assertEquals(3, pv.depth());
        pv.add("Test7");
        assertEquals(4, pv.depth());
    }

    // test metode size

    @Test
    void testSizeEmpty() {
        assertEquals(0, pv.size());
    }

    @Test
    void testSizeOne() {
        pv.add("Test");
        assertEquals(1, pv.size());
    }

    @Test
    void testSizeMultiple() {
        assertEquals(0, pv.size());
        pv.add("Test");
        assertEquals(1, pv.size());
        pv.add("Test1");
        assertEquals(2, pv.size());
        pv.add("Test2");
        assertEquals(3, pv.size());
    }

    // test metode isEmpty

    @Test
    void testIsEmptyEmpty() {
        assertTrue(pv.isEmpty());
    }

    @Test
    void testIsEmptyOne() {
        pv.add("Test");
        assertFalse(pv.isEmpty());
    }

    @Test
    void testIsEmptyMultiple() {
        pv.add("Test");
        pv.add("Test1");
        pv.add("Test2");
        assertFalse(pv.isEmpty());
    }
}