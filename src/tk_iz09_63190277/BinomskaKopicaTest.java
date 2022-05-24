package tk_iz09_63190277;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class BinomskaKopicaTest {

    private BinomskaKopica<Integer> kopica;

    @BeforeEach
    void setUp() {
        this.kopica = new BinomskaKopica<>();
    }

    @Nested
    class addTest {

        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void add() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            assertEquals(3, this.kopica.size());
        }

        @Test
        void addDuplicate() {
            this.kopica.add(1);
            this.kopica.add(1);
            this.kopica.add(1);
            assertEquals(3, this.kopica.size());
        }

        @Test
        void addListDuplicate() {
            this.kopica.add(1);
            this.kopica.add(1);
            this.kopica.add(1);
            assertEquals("[1, 1, 1]", this.kopica.asList().toString());
        }

        @Test
        void addListNormal() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            assertEquals("[3, 2, 1]", this.kopica.asList().toString());
        }

        @Test
        void addListEmpty() {
            assertEquals("[]", this.kopica.asList().toString());
        }

        @Test
        void addListBig() {
            for (int i = 1; i <= 15; i++)
                this.kopica.add(i);
            assertEquals("[15, 14, 13, 12, 10, 9, 11, 8, 4, 2, 1, 3, 6, 5, 7]", this.kopica.asList().toString());
        }
    }

    @Nested
    class removeFirstTest {
        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void removeFirstEmpty() {
            assertNull(this.kopica.removeFirst());
            assertEquals(0, this.kopica.size());
        }

        @Test
        void removeFirstOne() {
            this.kopica.add(1);
            assertEquals(1, this.kopica.removeFirst());
            assertEquals(0, this.kopica.size());
        }

        @Test
        void removeFirstMany() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            assertEquals(3, this.kopica.removeFirst());
            assertEquals(2, this.kopica.size());
            assertEquals("[2, 1]", this.kopica.asList().toString());
            assertEquals(2, this.kopica.removeFirst());
            assertEquals(1, this.kopica.size());
        }

        @Test
        void removeFirstManyBig() {
            for (int i = 1; i <= 15; i++)
                this.kopica.add(i);
            for (int i = 15; i >= 10; i--)
                assertEquals(i, this.kopica.removeFirst());
            assertEquals(9, this.kopica.size());
            assertEquals("[9, 8, 4, 2, 1, 3, 6, 5, 7]", this.kopica.asList().toString());
        }
    }

    @Nested
    class getFirstTest {
        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void getFirstEmpty() {
            assertNull(this.kopica.getFirst());
        }

        @Test
        void getFirstOne() {
            this.kopica.add(1);
            assertEquals(1, this.kopica.getFirst());
        }

        @Test
        void getFirstMany() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            assertEquals(3, this.kopica.getFirst());
        }

        @Test
        void getFirstManyBig() {
            int max = 0;
            int tmp;
            for (int i = 1; i <= 20; i++) {
                tmp = (int) (Math.random() * 100);
                if (tmp > max)
                    max = tmp;
                this.kopica.add(tmp);
            }
            assertEquals(max, this.kopica.getFirst());
        }
    }

    @Test
    void size() {
        assertEquals(0, this.kopica.size());
    }

    @Nested
    class depthTest {
        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void depthEmpty() {
            assertEquals(0, this.kopica.depth());
        }

        @Test
        void depthZero() {
            this.kopica.add(1);
            assertEquals(0, this.kopica.depth());
        }

        @Test
        void depthOne() {
            this.kopica.add(1);
            this.kopica.add(2);
            assertEquals(1, this.kopica.depth());
        }

        @Test
        void depthOneMultiple() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            assertEquals(1, this.kopica.depth());
        }

        @Test
        void depthTwo() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            this.kopica.add(4);
            assertEquals(2, this.kopica.depth());
        }

        @Test
        void depthTwoMultiple() {
            for (int i = 1; i <= 7; i++)
                this.kopica.add(i);
            assertEquals(2, this.kopica.depth());
        }

        @Test
        void depthFour() {
            for (int i = 1; i <= 16; i++)
                this.kopica.add(i);
            assertEquals(4, this.kopica.depth());
        }

        @Test
        void depthFourMultiple() {
            for (int i = 1; i <= 27; i++)
                this.kopica.add(i);
            assertEquals(4, this.kopica.depth());
        }
    }


    @Nested
    class isEmptyTest {
        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void isEmpty() {
            assertTrue(this.kopica.isEmpty());
        }

        @Test
        void isEmptyFalse() {
            this.kopica.add(1);
            assertFalse(this.kopica.isEmpty());
        }
    }

    @Nested
    class removeTest {
        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void removeEmpty() {
            assertNull(this.kopica.remove(1));
        }

        @Test
        void removeOne() {
            this.kopica.add(1);
            assertEquals(1, this.kopica.remove(1));
            assertEquals(0, this.kopica.size());
        }

        @Test
        void removeMultiple() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            this.kopica.add(4);
            this.kopica.add(5);
            assertEquals(3, this.kopica.remove(3));
            assertEquals(4, this.kopica.remove(4));
            assertEquals(5, this.kopica.remove(5));
            assertEquals(2, this.kopica.size());
            assertEquals("[2, 1]", this.kopica.asList().toString());
        }

        @Test
        void removeNotExisting() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            this.kopica.add(4);
            assertNull(this.kopica.remove(5));
        }

        @Test
        void removeDuplicate() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            this.kopica.add(1);
            assertEquals(1, this.kopica.remove(1));
            assertEquals(1, this.kopica.remove(1));
            assertEquals(2, this.kopica.size());
            assertEquals("[3, 2]", this.kopica.asList().toString());
        }

        @Test
        void removeDeleted() {
            this.kopica.add(1);
            this.kopica.add(2);
            this.kopica.add(3);
            assertEquals(1, this.kopica.remove(1));
            assertNull(this.kopica.remove(1));
            assertEquals(2, this.kopica.size());
        }

        @Test
        void removeBig() {
            for (int i = 1; i <= 20; i++)
                this.kopica.add(i);
            for (int i = 1; i < 10; i+=2)
                assertEquals(i, this.kopica.remove(i));
            //assertEquals("[11, 12, 10, 16, 15, 14, 13, 6, 4, 2, 8]", this.kopica.asList().toString());
        }
    }

    @Nested
    class existsTest {
        private BinomskaKopica<Integer> kopica;

        @BeforeEach
        void setUp() {
            this.kopica = new BinomskaKopica<>();
        }

        @Test
        void existsEmpty() {
            assertThrows(EmptyStackException.class, () -> this.kopica.exists(1));
        }

        @Test
        void existsFalse() {
            this.kopica.add(1);
            assertFalse(this.kopica.exists(2));
        }

        @Test
        void existsTrue() {
            this.kopica.add(1);
            assertTrue(this.kopica.exists(1));
        }

        @Test
        void existsBigFalse() {
            for (int i = 1; i <= 15; i++)
                this.kopica.add(i);
            assertFalse(this.kopica.exists(16));
        }

        @Test
        void existsBigTrue() {
            for (int i = 1; i <= 15; i++)
                this.kopica.add(i);
            assertTrue(this.kopica.exists(7));
        }

    }

    @Test
    void asList() {
        assertEquals("[]", this.kopica.asList().toString());
    }
}