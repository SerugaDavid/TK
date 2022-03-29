package Izziv3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    @Test
    void add1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(15);
    }
    @Test
    void add2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
        }
    }
    @Test
    void add3() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(-10);
    }
    @Test
    void add4() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(null);
    }

    @Test
    void removeFirst1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(15);
        assert instance.removeFirst() == 15;
    }
    @Test
    void removeFirst2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
        }
        for (int i = 9; i >= 0; i--) {
            assert instance.removeFirst() == i;
        }
    }
    @Test
    void removeFirst3() {
        Sklad<Integer> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.removeFirst();});
    }
    @Test
    void removeFirst4() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(15);
        instance.add(10);
        assert instance.removeFirst() == 10;
        assert instance.removeFirst() == 15;
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.removeFirst();});
    }

    @Test
    void getFirst1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(15);
        instance.add(10);
        assert instance.getFirst() == 10;
    }
    @Test
    void getFirst2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
            assert instance.getFirst() == i;
        }
    }
    @Test
    void getFirst3() {
        Sklad<Integer> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.getFirst();});
    }
    @Test
    void getFirst4() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
            assert instance.getFirst() == i;
        }
        for (int i = 9; i >= 0; i--) {
            assert instance.getFirst() == i;
            instance.removeFirst();
        }
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.getFirst();});
    }

    @Test
    void size1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.add(15);
        assert instance.size() == 1;
    }
    @Test
    void size2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
        }
        assert instance.size() == 10;
    }
    @Test
    void size3() {
        Sklad<Integer> instance = new Sklad<>();
        assert instance.size() == 0;
    }
    @Test
    void size4() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            assert instance.size() == i;
            instance.add(i);
        }
        for (int i = 9; i >= 0; i--) {
            instance.removeFirst();
            assert instance.size() == i;
        }
        assert instance.size() == 0;
    }
}