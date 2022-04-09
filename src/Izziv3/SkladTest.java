package Izziv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    private Sklad<Integer> instance;

    @BeforeEach
    void setUp() {
        this.instance = new Sklad<>();
    }


    @Test
    void add1() {
        this.instance.add(15);
    }
    @Test
    void add2() {
        for (int i = 0; i < 10; i++) {
            this.instance.add(i);
        }
    }
    @Test
    void add3() {
        this.instance.add(-10);
    }
    @Test
    void add4() {
        this.instance.add(null);
    }

    @Test
    void removeFirst1() {
        this.instance.add(15);
        assert this.instance.removeFirst() == 15;
    }
    @Test
    void removeFirst2() {
        for (int i = 0; i < 10; i++) {
            this.instance.add(i);
        }
        for (int i = 9; i >= 0; i--) {
            assert this.instance.removeFirst() == i;
        }
    }
    @Test
    void removeFirst3() {
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {this.instance.removeFirst();});
    }
    @Test
    void removeFirst4() {
        this.instance.add(15);
        this.instance.add(10);
        assert this.instance.removeFirst() == 10;
        assert this.instance.removeFirst() == 15;
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {this.instance.removeFirst();});
    }

    @Test
    void getFirst1() {
        this.instance.add(15);
        this.instance.add(10);
        assert this.instance.getFirst() == 10;
    }
    @Test
    void getFirst2() {
        for (int i = 0; i < 10; i++) {
            this.instance.add(i);
            assert this.instance.getFirst() == i;
        }
    }
    @Test
    void getFirst3() {
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {this.instance.getFirst();});
    }
    @Test
    void getFirst4() {
        for (int i = 0; i < 10; i++) {
            this.instance.add(i);
            assert this.instance.getFirst() == i;
        }
        for (int i = 9; i >= 0; i--) {
            assert this.instance.getFirst() == i;
            this.instance.removeFirst();
        }
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {this.instance.getFirst();});
    }

    @Test
    void size1() {
        this.instance.add(15);
        assert this.instance.size() == 1;
    }
    @Test
    void size2() {
        for (int i = 0; i < 10; i++) {
            this.instance.add(i);
        }
        assert this.instance.size() == 10;
    }
    @Test
    void size3() {
        assert this.instance.size() == 0;
    }
    @Test
    void size4() {
        for (int i = 0; i < 10; i++) {
            assert this.instance.size() == i;
            this.instance.add(i);
        }
        for (int i = 9; i >= 0; i--) {
            this.instance.removeFirst();
            assert this.instance.size() == i;
        }
        assert this.instance.size() == 0;
    }
    @Test
    void remove() {
        for (int i = 0; i < 3; i++) {
            this.instance.add(i);
        }
        assert this.instance.remove(1) == 1;
        assert this.instance.removeFirst() == 2;
        assert this.instance.removeFirst() == 0;
    }

    @Test
    void remove2() {
        for (int i = 0; i < 3; i++) {
            this.instance.add(i);
        }
        assert this.instance.remove(1) == 1;
        assert this.instance.remove(2) == 2;
        assert this.instance.removeFirst() == 0;
    }
    @Test
    void remove3() {
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {this.instance.remove(1);});
    }
    @Test
    void remove4() {
        for (int i = 0; i < 3; i++) {
            this.instance.add(i);
        }
        assert this.instance.remove(1) == 1;
        assert this.instance.remove(2) == 2;
        assert this.instance.remove(0) == 0;
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {this.instance.remove(3);});
    }
    @Test
    void exists() {
        for (int i = 0; i < 3; i++) {
            this.instance.add(i);
        }
        assert this.instance.exists(1);
        assert this.instance.exists(2);
    }
    @Test
    void exists2() {
        for (int i = 0; i < 3; i++) {
            this.instance.add(i);
        }
        assert !this.instance.exists(3);
        assert !this.instance.exists(4);
        assert this.instance.exists(2);
    }
    @Test
    void exists3() {
        assert !this.instance.exists(1);
        assert !this.instance.exists(2);
        assert !this.instance.exists(3);
    }
    @Test
    void exists4() {
        for (int i = 0; i < 3; i++) {
            this.instance.add(i);
        }
        assert this.instance.exists(2);
        this.instance.removeFirst();
        assert !this.instance.exists(2);
        assert this.instance.exists(1);
        this.instance.removeFirst();
        assert !this.instance.exists(1);
    }
}