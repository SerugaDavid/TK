package Vaje2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    @Test
    void push1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
    }
    @Test
    void push2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.push(i);
        }
    }
    @Test
    void push3() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(-10);
    }
    @Test
    void push4() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(null);
    }

    @Test
    void pop1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        assert instance.pop() == 15;
    }
    @Test
    void pop2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.push(i);
        }
        for (int i = 9; i >= 0; i--) {
            assert instance.pop() == i;
        }
    }
    @Test
    void pop3() {
        Sklad<Integer> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.pop();});
    }
    @Test
    void pop4() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        instance.push(10);
        assert instance.pop() == 10;
        assert instance.pop() == 15;
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.pop();});
    }

    @Test
    void top1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        instance.push(10);
        assert instance.top() == 10;
    }
    @Test
    void top2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.push(i);
            assert instance.top() == i;
        }
    }
    @Test
    void top3() {
        Sklad<Integer> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.top();});
    }
    @Test
    void top4() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.push(i);
            assert instance.top() == i;
        }
        for (int i = 9; i >= 0; i--) {
            assert instance.top() == i;
            instance.pop();
        }
        assertThrows(java.util.NoSuchElementException.class,
                ()-> {instance.top();});
    }

    @Test
    void size1() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        assert instance.size() == 1;
    }
    @Test
    void size2() {
        Sklad<Integer> instance = new Sklad<>();
        for (int i = 0; i < 10; i++) {
            instance.push(i);
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
            instance.push(i);
        }
        for (int i = 9; i >= 0; i--) {
            instance.pop();
            assert instance.size() == i;
        }
        assert instance.size() == 0;
    }
}