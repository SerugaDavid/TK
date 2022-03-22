package Vaje2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeznamiUVTest {

    @BeforeEach
    void setUp() {
        SeznamiUV uv = new SeznamiUV();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPushBasic() {
        System.out.println("testPushBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
    }

    @Disabled("To be implemented at a later stage")
    @Test
    void testPushMultipleWords() {
        System.out.println("testPushMultipleWords");
        assertEquals("OK",
                uv.processInput("push \"Test with multiple words\""));
        assertEquals("1", uv.processInput("count"));
        assertEquals("OK", uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
    }

    @Test
    void testPushNothing() {
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string",
                uv.processInput("push"));
    }

    @Test
    void testPopBasic() {
        System.out.println("testPopBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("Test2", uv.processInput("pop"));
        assertEquals("Test1", uv.processInput("pop"));
    }

    @Disabled("To be implemented at a later stage")
    @Test
    void testPopMultipleWords() {
        System.out.println("testPopMultipleWords");
        assertEquals("OK", uv.processInput(
                "push \"Test with multiple words\""));
        assertEquals("OK", uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
        assertEquals("Another test with multiple words",
                uv.processInput("pop"));
        assertEquals("1", uv.processInput("count"));
        assertEquals("Test with multiple words",
                uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    void testPopNothing() {
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
        assertEquals("Error: please specify a string",
                uv.processInput("push"));
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
    }

    @Test
    void testResetOnEmpty() {
        System.out.println("testResetOnEmpty");
        assertEquals("OK", uv.processInput("reset"));
    }

    @Test
    void testResetOnFull() {
        System.out.println("testResetOnFull");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    void testCountOnEmpty() {
        System.out.println("testCountOnEmpty");
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    void testCountOne() {
        System.out.println("testCountOne");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("1", uv.processInput("count"));
    }

    @Test
    void testCountTwo() {
        System.out.println("testCountTwo");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("2", uv.processInput("count"));
    }
}