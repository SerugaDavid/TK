package Vaje2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    @Test
    void push() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
    }

    @Test
    void pop() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        instance.push(10);
        assert instance.pop() == 10;
    }

    @Test
    void top() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        instance.push(10);
        assert instance.top() == 10;
    }

    @Test
    void size() {
        Sklad<Integer> instance = new Sklad<>();
        instance.push(15);
        instance.push(10);
        instance.pop();
        assert instance.size() == 1;
    }
}