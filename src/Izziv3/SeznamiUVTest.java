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
    
    // Sklad testi
    @Test
    void tests_addBasic() {
        System.out.println("tests_addBasic");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
    }

    //@Disabled("To be implemented at a later stage")
    @Test
    void tests_addMultipleWords() {
        System.out.println("tests_addMultipleWords");
        assertEquals("OK",
                this.uv.processInput("s_add \"Test with multiple words\""));
        assertEquals("1", this.uv.processInput("s_size"));
        assertEquals("OK", this.uv.processInput(
                "s_add \"Another test with multiple words\""));
        assertEquals("2", this.uv.processInput("s_size"));
    }

    @Test
    void tests_addNothing() {
        System.out.println("tests_addNothing");
        assertEquals("Error: please specify a string",
                this.uv.processInput("s_add"));
    }

    @Test
    void tests_removeBasic() {
        System.out.println("tests_removeBasic");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("Test2", this.uv.processInput("s_remove"));
        assertEquals("Test1", this.uv.processInput("s_remove"));
    }

    //@Disabled("To be implemented at a later stage")
    @Test
    void tests_removeMultipleWords() {
        System.out.println("tests_removeMultipleWords");
        assertEquals("OK", this.uv.processInput(
                "s_add \"Test with multiple words\""));
        assertEquals("OK", this.uv.processInput(
                "s_add \"Another test with multiple words\""));
        assertEquals("2", this.uv.processInput("s_size"));
        assertEquals("Another test with multiple words",
                this.uv.processInput("s_remove"));
        assertEquals("1", this.uv.processInput("s_size"));
        assertEquals("Test with multiple words",
                this.uv.processInput("s_remove"));
        assertEquals("0", this.uv.processInput("s_size"));
    }

    @Test
    void tests_removeNothing() {
        System.out.println("tests_removeNothing");
        assertEquals("Error: stack is empty",
                this.uv.processInput("s_remove"));
        assertEquals("Error: please specify a string",
                this.uv.processInput("s_add"));
        assertEquals("Error: stack is empty",
                this.uv.processInput("s_remove"));
    }

    @Test
    void tests_resetOnEmpty() {
        System.out.println("tests_resetOnEmpty");
        assertEquals("OK", this.uv.processInput("s_reset"));
    }

    @Test
    void tests_resetOnFull() {
        System.out.println("tests_resetOnFull");
        assertEquals("OK", this.uv.processInput("s_add Test"));
        assertEquals("OK", this.uv.processInput("s_reset"));
        assertEquals("Error: stack is empty",
                this.uv.processInput("s_remove"));
        assertEquals("0", this.uv.processInput("s_size"));
    }

    @Test
    void tests_sizeOnEmpty() {
        System.out.println("tests_sizeOnEmpty");
        assertEquals("0", this.uv.processInput("s_size"));
    }

    @Test
    void tests_sizeOne() {
        System.out.println("tests_sizeOne");
        assertEquals("OK", this.uv.processInput("s_add Test"));
        assertEquals("1", this.uv.processInput("s_size"));
    }

    @Test
    void tests_sizeTwo() {
        System.out.println("tests_sizeTwo");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("2", this.uv.processInput("s_size"));
    }

    @Test
    void s_isTopEmpty() {
        System.out.println("s_isTopEmpty");
        assertEquals("Error: stack is empty", this.uv.processInput("s_isTop Test"));
    }

    @Test
    void s_isTopEmptyString() {
        System.out.println("s_isTopEmptyString");
        assertEquals("Error: please specify a string", this.uv.processInput("s_isTop"));
    }

    @Test
    void s_isTopWrong() {
        System.out.println("s_isTopWrong");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("Error: wrong element", this.uv.processInput("s_isTop Test1"));
    }

    @Test
    void s_isTopCorrect() {
        System.out.println("s_isTopCorrect");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("OK", this.uv.processInput("s_isTop Test2"));
    }

    @Test
    void s_searchEmptyString() {
        System.out.println("s_searchEmptyString");
        assertEquals("Error: please specify a string", this.uv.processInput("s_search"));
    }

    @Test
    void s_searchZero() {
        System.out.println("s_searchZero");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("OK", this.uv.processInput("s_add Test3"));
        assertEquals("0", this.uv.processInput("s_search Test3"));
    }

    @Test
    void s_searchOne() {
        System.out.println("s_searchOne");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("OK", this.uv.processInput("s_add Test3"));
        assertEquals("1", this.uv.processInput("s_search Test2"));
    }

    @Test
    void s_searchTwo() {
        System.out.println("s_searchTwo");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("OK", this.uv.processInput("s_add Test3"));
        assertEquals("2", this.uv.processInput("s_search Test1"));
    }

    @Test
    void s_searchWrongElement() {
        System.out.println("s_searchWrongElement");
        assertEquals("OK", this.uv.processInput("s_add Test1"));
        assertEquals("OK", this.uv.processInput("s_add Test2"));
        assertEquals("OK", this.uv.processInput("s_add Test3"));
        assertEquals("-1", this.uv.processInput("s_search Test4"));
    }
    
    // prioritetna vrsta testi
    
    @Test
    void pq_addEmptyString() {
        System.out.println("pq_addEmptyString");
        assertEquals("Error: please specify a string", this.uv.processInput("pq_add"));
    }

    @Test
    void pq_addElements() {
        System.out.println("pq_addElements");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("OK", this.uv.processInput("pq_add Test2"));
        assertEquals("OK", this.uv.processInput("pq_add Test3"));
        assertEquals("3", this.uv.processInput("pq_size"));
    }

    @Test
    void pq_isEmptyNotEmpty() {
        System.out.println("pq_isEmptyNotEmpty");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("OK", this.uv.processInput("pq_add Test2"));
        assertEquals("OK", this.uv.processInput("pq_add Test3"));
        assertEquals("false", this.uv.processInput("pq_isEmpty"));
    }

    @Test
    void pq_isEmptyEmpty() {
        System.out.println("pq_isEmptyEmpty");
        assertEquals("true", this.uv.processInput("pq_isEmpty"));
    }

    @Test
    void pq_removeEmpty() {
        System.out.println("pq_removeEmpty");
        assertEquals("Error: priority queue is empty", this.uv.processInput("pq_remove_first"));
    }

    @Test
    void pq_removeOne() {
        System.out.println("pq_removeOne");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("OK", this.uv.processInput("pq_add Test2"));
        assertEquals("OK", this.uv.processInput("pq_add Test3"));
        assertEquals("Test3", this.uv.processInput("pq_remove_first"));
        assertEquals("2", this.uv.processInput("pq_size"));
    }

    @Test
    void pq_removeThree() {
        System.out.println("pq_removeThree");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("OK", this.uv.processInput("pq_add Test2"));
        assertEquals("OK", this.uv.processInput("pq_add Test3"));
        assertEquals("Test3", this.uv.processInput("pq_remove_first"));
        assertEquals("Test2", this.uv.processInput("pq_remove_first"));
        assertEquals("Test1", this.uv.processInput("pq_remove_first"));
        assertEquals("0", this.uv.processInput("pq_size"));
        assertEquals("Error: priority queue is empty", this.uv.processInput("pq_remove_first"));
    }

    @Test
    void pq_getFirstEmpty() {
        System.out.println("pq_getFirstEmpty");
        assertEquals("Error: priority queue is empty", this.uv.processInput("pq_get_first"));
    }

    @Test
    void pq_getFirstOne() {
        System.out.println("pq_getFirstOne");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("OK", this.uv.processInput("pq_add Test3"));
        assertEquals("OK", this.uv.processInput("pq_add Test2"));
        assertEquals("Test3", this.uv.processInput("pq_get_first"));
    }

    @Test
    void pq_depthEmpty() {
        System.out.println("pq_depthEmpty");
        assertEquals("0", this.uv.processInput("pq_depth"));
    }

    @Test
    void pq_depthOne() {
        System.out.println("pq_depthOne");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("1", this.uv.processInput("pq_depth"));
    }

    @Test
    void pq_depthFour() {
        System.out.println("pq_depthThree");
        for (int i = 0; i < 8; i++) {
            assertEquals("OK", this.uv.processInput("pq_add Test" + i));
        }
        assertEquals("4", this.uv.processInput("pq_depth"));
    }

    @Test
    void pq_sizeEmpty() {
        System.out.println("pq_sizeEmpty");
        assertEquals("0", this.uv.processInput("pq_size"));
    }

    @Test
    void pq_sizeOne() {
        System.out.println("pq_sizeOne");
        assertEquals("OK", this.uv.processInput("pq_add Test1"));
        assertEquals("1", this.uv.processInput("pq_size"));
    }

    @Test
    void pq_sizeFour() {
        System.out.println("pq_sizeFour");
        for (int i = 0; i < 4; i++) {
            assertEquals("OK", this.uv.processInput("pq_add Test" + i));
        }
        assertEquals("4", this.uv.processInput("pq_size"));
    }
}