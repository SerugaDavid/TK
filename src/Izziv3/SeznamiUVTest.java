package Izziv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeznamiUVTest {

    SeznamiUV uv;
    
    @BeforeEach
    void setUp() {
        this.uv = new SeznamiUV();
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void testPushBasic() {
        System.out.println("testPushBasic");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
    }

    //@Disabled("To be implemented at a later stage")
    @Test
    void testPushMultipleWords() {
        System.out.println("testPushMultipleWords");
        assertEquals("OK",
                this.uv.processInput("push \"Test with multiple words\""));
        assertEquals("1", this.uv.processInput("count"));
        assertEquals("OK", this.uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", this.uv.processInput("count"));
    }

    @Test
    void testPushNothing() {
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string",
                this.uv.processInput("push"));
    }

    @Test
    void testPopBasic() {
        System.out.println("testPopBasic");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("Test2", this.uv.processInput("pop"));
        assertEquals("Test1", this.uv.processInput("pop"));
    }

    //@Disabled("To be implemented at a later stage")
    @Test
    void testPopMultipleWords() {
        System.out.println("testPopMultipleWords");
        assertEquals("OK", this.uv.processInput(
                "push \"Test with multiple words\""));
        assertEquals("OK", this.uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", this.uv.processInput("count"));
        assertEquals("Another test with multiple words",
                this.uv.processInput("pop"));
        assertEquals("1", this.uv.processInput("count"));
        assertEquals("Test with multiple words",
                this.uv.processInput("pop"));
        assertEquals("0", this.uv.processInput("count"));
    }

    @Test
    void testPopNothing() {
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty",
                this.uv.processInput("pop"));
        assertEquals("Error: please specify a string",
                this.uv.processInput("push"));
        assertEquals("Error: stack is empty",
                this.uv.processInput("pop"));
    }

    @Test
    void testResetOnEmpty() {
        System.out.println("testResetOnEmpty");
        assertEquals("OK", this.uv.processInput("reset"));
    }

    @Test
    void testResetOnFull() {
        System.out.println("testResetOnFull");
        assertEquals("OK", this.uv.processInput("push Test"));
        assertEquals("OK", this.uv.processInput("reset"));
        assertEquals("Error: stack is empty",
                this.uv.processInput("pop"));
        assertEquals("0", this.uv.processInput("count"));
    }

    @Test
    void testCountOnEmpty() {
        System.out.println("testCountOnEmpty");
        assertEquals("0", this.uv.processInput("count"));
    }

    @Test
    void testCountOne() {
        System.out.println("testCountOne");
        assertEquals("OK", this.uv.processInput("push Test"));
        assertEquals("1", this.uv.processInput("count"));
    }

    @Test
    void testCountTwo() {
        System.out.println("testCountTwo");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("2", this.uv.processInput("count"));
    }

    @Test
    void isTopEmpty() {
        System.out.println("isTopEmpty");
        assertEquals("Error: stack is empty", this.uv.processInput("isTop Test"));
    }

    @Test
    void isTopEmptyString() {
        System.out.println("isTopEmptyString");
        assertEquals("Error: please specify a string", this.uv.processInput("isTop"));
    }

    @Test
    void isTopWrong() {
        System.out.println("isTopWrong");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("Error: wrong element", this.uv.processInput("isTop Test1"));
    }

    @Test
    void isTopCorrect() {
        System.out.println("isTopCorrect");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("OK", this.uv.processInput("isTop Test2"));
    }

    @Test
    void searchEmptyString() {
        System.out.println("searchEmptyString");
        assertEquals("Error: please specify a string", this.uv.processInput("search"));
    }

    @Test
    void searchZero() {
        System.out.println("searchZero");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("OK", this.uv.processInput("push Test3"));
        assertEquals("0", this.uv.processInput("search Test3"));
    }

    @Test
    void searchOne() {
        System.out.println("searchOne");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("OK", this.uv.processInput("push Test3"));
        assertEquals("1", this.uv.processInput("search Test2"));
    }

    @Test
    void searchTwo() {
        System.out.println("searchTwo");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("OK", this.uv.processInput("push Test3"));
        assertEquals("2", this.uv.processInput("search Test1"));
    }

    @Test
    void searchWrongElement() {
        System.out.println("searchWrongElement");
        assertEquals("OK", this.uv.processInput("push Test1"));
        assertEquals("OK", this.uv.processInput("push Test2"));
        assertEquals("OK", this.uv.processInput("push Test3"));
        assertEquals("-1", this.uv.processInput("search Test4"));
    }
}