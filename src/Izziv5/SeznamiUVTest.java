package Izziv5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SeznamiUVTest {

    SeznamiUV uv;
    
    @BeforeEach
    void setUp() {
        this.uv = new SeznamiUV();
    }
    
//    // Sklad testi
//    @Test
//    void tests_addBasic() {
//        System.out.println("tests_addBasic");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//    }
//
//    //@Disabled("To be implemented at a later stage")
//    @Test
//    void tests_addMultipleWords() {
//        System.out.println("tests_addMultipleWords");
//        assertEquals("OK",
//                this.uv.processInput("s_add \"Test with multiple words\""));
//        assertEquals("1", this.uv.processInput("s_size"));
//        assertEquals("OK", this.uv.processInput(
//                "s_add \"Another test with multiple words\""));
//        assertEquals("2", this.uv.processInput("s_size"));
//    }
//
//    @Test
//    void tests_addNothing() {
//        System.out.println("tests_addNothing");
//        assertEquals("Error: please specify a string",
//                this.uv.processInput("s_add"));
//    }
//
//    @Test
//    void tests_removeBasic() {
//        System.out.println("tests_removeBasic");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("Test2", this.uv.processInput("s_removeTop"));
//        assertEquals("Test1", this.uv.processInput("s_removeTop"));
//    }
//
//    //@Disabled("To be implemented at a later stage")
//    @Test
//    void tests_removeMultipleWords() {
//        System.out.println("tests_removeMultipleWords");
//        assertEquals("OK", this.uv.processInput(
//                "s_add \"Test with multiple words\""));
//        assertEquals("OK", this.uv.processInput(
//                "s_add \"Another test with multiple words\""));
//        assertEquals("2", this.uv.processInput("s_size"));
//        assertEquals("Another test with multiple words",
//                this.uv.processInput("s_removeTop"));
//        assertEquals("1", this.uv.processInput("s_size"));
//        assertEquals("Test with multiple words",
//                this.uv.processInput("s_removeTop"));
//        assertEquals("0", this.uv.processInput("s_size"));
//    }
//
//    @Test
//    void tests_removeNothing() {
//        System.out.println("tests_removeNothing");
//        assertEquals("Error: stack is empty",
//                this.uv.processInput("s_removeTop"));
//        assertEquals("Error: please specify a string",
//                this.uv.processInput("s_add"));
//        assertEquals("Error: stack is empty",
//                this.uv.processInput("s_removeTop"));
//    }
//
//    @Test
//    void tests_resetOnEmpty() {
//        System.out.println("tests_resetOnEmpty");
//        assertEquals("OK", this.uv.processInput("s_reset"));
//    }
//
//    @Test
//    void tests_resetOnFull() {
//        System.out.println("tests_resetOnFull");
//        assertEquals("OK", this.uv.processInput("s_add Test"));
//        assertEquals("OK", this.uv.processInput("s_reset"));
//        assertEquals("Error: stack is empty",
//                this.uv.processInput("s_removeTop"));
//        assertEquals("0", this.uv.processInput("s_size"));
//    }
//
//    @Test
//    void tests_sizeOnEmpty() {
//        System.out.println("tests_sizeOnEmpty");
//        assertEquals("0", this.uv.processInput("s_size"));
//    }
//
//    @Test
//    void tests_sizeOne() {
//        System.out.println("tests_sizeOne");
//        assertEquals("OK", this.uv.processInput("s_add Test"));
//        assertEquals("1", this.uv.processInput("s_size"));
//    }
//
//    @Test
//    void tests_sizeTwo() {
//        System.out.println("tests_sizeTwo");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("2", this.uv.processInput("s_size"));
//    }
//
//    @Test
//    void s_isTopEmpty() {
//        System.out.println("s_isTopEmpty");
//        assertEquals("Error: stack is empty", this.uv.processInput("s_isTop Test"));
//    }
//
//    @Test
//    void s_isTopEmptyString() {
//        System.out.println("s_isTopEmptyString");
//        assertEquals("Error: please specify a string", this.uv.processInput("s_isTop"));
//    }
//
//    @Test
//    void s_isTopWrong() {
//        System.out.println("s_isTopWrong");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("Error: wrong element", this.uv.processInput("s_isTop Test1"));
//    }
//
//    @Test
//    void s_isTopCorrect() {
//        System.out.println("s_isTopCorrect");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_isTop Test2"));
//    }
//
//    @Test
//    void s_searchEmptyString() {
//        System.out.println("s_searchEmptyString");
//        assertEquals("Error: please specify a string", this.uv.processInput("s_search"));
//    }
//
//    @Test
//    void s_searchZero() {
//        System.out.println("s_searchZero");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("0", this.uv.processInput("s_search Test3"));
//    }
//
//    @Test
//    void s_searchOne() {
//        System.out.println("s_searchOne");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("1", this.uv.processInput("s_search Test2"));
//    }
//
//    @Test
//    void s_searchTwo() {
//        System.out.println("s_searchTwo");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("2", this.uv.processInput("s_search Test1"));
//    }
//
//    @Test
//    void s_searchWrongElement() {
//        System.out.println("s_searchWrongElement");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("-1", this.uv.processInput("s_search Test4"));
//    }
//
//    @Test
//    void s_removeElementEmpty() {
//        System.out.println("s_removeElementEmpty");
//        assertEquals("Error: Data structure is empty", this.uv.processInput("s_remove Test"));
//    }
//
//    @Test
//    void s_removeElementEmptyString() {
//        System.out.println("s_removeElementEmptyString");
//        assertEquals("Error: Please specify a string", this.uv.processInput("s_remove"));
//    }
//
//    @Test
//    void s_removeElementWrong() {
//        System.out.println("s_removeElementWrong");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("Error: Element not found", this.uv.processInput("s_remove Test4"));
//    }
//
//    @Test
//    void s_removeElementCorrect() {
//        System.out.println("s_removeElementCorrect");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("Test2", this.uv.processInput("s_remove Test2"));
//    }
//
//    @Test
//    void s_existsEmpty() {
//        System.out.println("s_existsEmpty");
//        assertEquals("Error: Data structure is empty", this.uv.processInput("s_exists Test"));
//    }
//
//    @Test
//    void s_existsEmptyString() {
//        System.out.println("s_existsEmptyString");
//        assertEquals("Error: Please specify a string", this.uv.processInput("s_exists"));
//    }
//
//    @Test
//    void s_existsWrong() {
//        System.out.println("s_existsWrong");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("Element does not exist in data structure", this.uv.processInput("s_exists Test4"));
//    }
//
//    @Test
//    void s_existsCorrect() {
//        System.out.println("s_existsCorrect");
//        assertEquals("OK", this.uv.processInput("s_add Test1"));
//        assertEquals("OK", this.uv.processInput("s_add Test2"));
//        assertEquals("OK", this.uv.processInput("s_add Test3"));
//        assertEquals("Element exists in data structure", this.uv.processInput("s_exists Test2"));
//    }
//
//    // prioritetna vrsta testi
//
//    @Test
//    void pq_addEmptyString() {
//        System.out.println("pq_addEmptyString");
//        assertEquals("Error: please specify a string", this.uv.processInput("pq_add"));
//    }
//
//    @Test
//    void pq_addElements() {
//        System.out.println("pq_addElements");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("3", this.uv.processInput("pq_size"));
//    }
//
//    @Test
//    void pq_isEmptyNotEmpty() {
//        System.out.println("pq_isEmptyNotEmpty");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("false", this.uv.processInput("pq_isEmpty"));
//    }
//
//    @Test
//    void pq_isEmptyEmpty() {
//        System.out.println("pq_isEmptyEmpty");
//        assertEquals("true", this.uv.processInput("pq_isEmpty"));
//    }
//
//    @Test
//    void pq_removeEmpty() {
//        System.out.println("pq_removeEmpty");
//        assertEquals("Error: priority queue is empty", this.uv.processInput("pq_remove_first"));
//    }
//
//    @Test
//    void pq_removeOne() {
//        System.out.println("pq_removeOne");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Test3", this.uv.processInput("pq_remove_first"));
//        assertEquals("2", this.uv.processInput("pq_size"));
//    }
//
//    @Test
//    void pq_removeThree() {
//        System.out.println("pq_removeThree");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Test3", this.uv.processInput("pq_remove_first"));
//        assertEquals("Test2", this.uv.processInput("pq_remove_first"));
//        assertEquals("Test1", this.uv.processInput("pq_remove_first"));
//        assertEquals("0", this.uv.processInput("pq_size"));
//        assertEquals("Error: priority queue is empty", this.uv.processInput("pq_remove_first"));
//    }
//
//    @Test
//    void pq_getFirstEmpty() {
//        System.out.println("pq_getFirstEmpty");
//        assertEquals("Error: priority queue is empty", this.uv.processInput("pq_get_first"));
//    }
//
//    @Test
//    void pq_getFirstOne() {
//        System.out.println("pq_getFirstOne");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("Test3", this.uv.processInput("pq_get_first"));
//    }
//
//    @Test
//    void pq_depthEmpty() {
//        System.out.println("pq_depthEmpty");
//        assertEquals("0", this.uv.processInput("pq_depth"));
//    }
//
//    @Test
//    void pq_depthOne() {
//        System.out.println("pq_depthOne");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("1", this.uv.processInput("pq_depth"));
//    }
//
//    @Test
//    void pq_depthFour() {
//        System.out.println("pq_depthThree");
//        for (int i = 0; i < 8; i++) {
//            assertEquals("OK", this.uv.processInput("pq_add Test" + i));
//        }
//        assertEquals("4", this.uv.processInput("pq_depth"));
//    }
//
//    @Test
//    void pq_sizeEmpty() {
//        System.out.println("pq_sizeEmpty");
//        assertEquals("0", this.uv.processInput("pq_size"));
//    }
//
//    @Test
//    void pq_sizeOne() {
//        System.out.println("pq_sizeOne");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("1", this.uv.processInput("pq_size"));
//    }
//
//    @Test
//    void pq_sizeFour() {
//        System.out.println("pq_sizeFour");
//        for (int i = 0; i < 4; i++) {
//            assertEquals("OK", this.uv.processInput("pq_add Test" + i));
//        }
//        assertEquals("4", this.uv.processInput("pq_size"));
//    }
//
//    @Test
//    void pq_removeElementEmpty() {
//        System.out.println("pq_removeElementEmpty");
//        assertEquals("Error: Data structure is empty", this.uv.processInput("pq_remove Test1"));
//    }
//
//    @Test
//    void pq_removeElementNotFound() {
//        System.out.println("pq_removeElementNotFound");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Error: Element not found", this.uv.processInput("pq_remove Test4"));
//    }
//
//    @Test
//    void pq_removeElementOne() {
//        System.out.println("pq_removeElementOne");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Test2", this.uv.processInput("pq_remove Test2"));
//        assertEquals("2", this.uv.processInput("pq_size"));
//    }
//
//    @Test
//    void pq_removeElementEmptyString() {
//        System.out.println("pq_removeElementTwo");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Error: Please specify a string", this.uv.processInput("pq_remove"));
//
//    }
//
//    @Test
//    void pq_existsEmpty() {
//        System.out.println("pq_existsEmpty");
//        assertEquals("Error: Data structure is empty", this.uv.processInput("pq_exists Test1"));
//    }
//
//    @Test
//    void pq_existsNotFound() {
//        System.out.println("pq_existsNotFound");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Element does not exist in data structure", this.uv.processInput("pq_exists Test4"));
//    }
//
//    @Test
//    void pq_existsOne() {
//        System.out.println("pq_existsOne");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Element exists in data structure", this.uv.processInput("pq_exists Test1"));
//    }
//
//    @Test
//    void pq_existsEmptyString() {
//        System.out.println("pq_existsEmptyString");
//        assertEquals("OK", this.uv.processInput("pq_add Test1"));
//        assertEquals("OK", this.uv.processInput("pq_add Test2"));
//        assertEquals("OK", this.uv.processInput("pq_add Test3"));
//        assertEquals("Error: Please specify a string", this.uv.processInput("pq_exists"));
//    }

    @Nested
    class testUse {

        SeznamiUV uv;

        @BeforeEach
        void setUp() {
            this.uv = new SeznamiUV();
        }

        @Nested
        class useTest {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @Test
            void useEmpty() {
                assertEquals("Error: please specify a data structure type (pv, sk, bst)", this.uv.processInput("use"));
            }

            @Test
            void useNotFound() {
                assertEquals("Error: please specify a correct data structure type (pv, sk, bst)", this.uv.processInput("use Test"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void useStructure(String structure) {
                assertEquals("OK", this.uv.processInput("use " + structure));
            }

        }

        @Nested
        class addTest {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void addEmpty(String structure) {
                assertEquals("OK", this.uv.processInput("use " + structure));
                assertEquals("Error: please specify a string", this.uv.processInput("add"));
                assertEquals("0", this.uv.processInput("size"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void addOne(String structure) {
                assertEquals("OK", this.uv.processInput("use " + structure));
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("1", this.uv.processInput("size"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void addThree(String structure) {
                assertEquals("OK", this.uv.processInput("use " + structure));
                assertEquals("OK", this.uv.processInput("add Test1"));
                assertEquals("OK", this.uv.processInput("add Test2"));
                assertEquals("OK", this.uv.processInput("add Test3"));
                assertEquals("3", this.uv.processInput("size"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void addThreeSame(String structure) {
                assertEquals("OK", this.uv.processInput("use " + structure));
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("OK", this.uv.processInput("add Test"));
                if (structure.equals("bst"))
                    assertEquals("1", this.uv.processInput("size"));
                else
                    assertEquals("3", this.uv.processInput("size"));
            }
        }

        @Nested
        class removeFirstTest {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }


            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void removeFirstEmpty(String structure) {
                assertEquals("OK", this.uv.processInput("use " + structure));
                assertEquals("Error: data structure is empty", this.uv.processInput("removeFirst"));
                assertEquals("0", this.uv.processInput("size"));
            }

            @Nested
            class removeFirstPV {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use pv");
                }

                @Test
                void removeFirstOne() {
                    assertEquals("OK", this.uv.processInput("add Test"));
                    assertEquals("Test", this.uv.processInput("removeFirst"));
                    assertEquals("0", this.uv.processInput("size"));
                }

                @Test
                void removeFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test3", this.uv.processInput("removeFirst"));
                    assertEquals("2", this.uv.processInput("size"));
                }

                @Test
                void removeFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    for (int i = 10; i > 0; i--)
                        assertEquals("Test" + String.valueOf(i), this.uv.processInput("removeFirst"));
                }
            }

            @Nested
            class removeFirstSK {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use sk");
                }

                @Test
                void removeFirstOne() {
                    assertEquals("OK", this.uv.processInput("add Test"));
                    assertEquals("Test", this.uv.processInput("removeFirst"));
                    assertEquals("0", this.uv.processInput("size"));
                }

                @Test
                void removeFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test3", this.uv.processInput("removeFirst"));
                    assertEquals("2", this.uv.processInput("size"));
                }

                @Test
                void removeFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    for (int i = numbers.length - 1; i >= 0; i--)
                        assertEquals("Test" + String.valueOf(numbers[i]), this.uv.processInput("removeFirst"));
                }
            }

            @Nested
            class removeFirstBST {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use bst");
                }

                @Test
                void removeFirstOne() {
                    assertEquals("OK", this.uv.processInput("add Test"));
                    assertEquals("Test", this.uv.processInput("removeFirst"));
                    assertEquals("0", this.uv.processInput("size"));
                }

                @Test
                void removeFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test1", this.uv.processInput("removeFirst"));
                    assertEquals("2", this.uv.processInput("size"));
                }

                @Test
                void removeFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    for (int i = 5; i <= 10; i++)
                        assertEquals("Test" + String.valueOf(numbers[i]), this.uv.processInput("removeFirst"));
                    assertEquals("2", this.uv.processInput("removeFirst"));
                    assertEquals("3", this.uv.processInput("removeFirst"));
                    assertEquals("4", this.uv.processInput("removeFirst"));
                    assertEquals("1", this.uv.processInput("removeFirst"));
                }
            }

            @Nested
            class removeFirstBK {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use bk");
                }

                @Test
                void removeFirstOne() {
                    assertEquals("OK", this.uv.processInput("add Test"));
                    assertEquals("Test", this.uv.processInput("removeFirst"));
                    assertEquals("0", this.uv.processInput("size"));
                }

                @Test
                void removeFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test3", this.uv.processInput("removeFirst"));
                    assertEquals("2", this.uv.processInput("size"));
                }

                @Test
                void removeFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    for (int i = 10; i > 0; i--)
                        assertEquals("Test" + String.valueOf(i), this.uv.processInput("removeFirst"));
                }
            }
        }

        @Nested
        class getFirst {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void getFirstEmpty(String type) {
                this.uv.processInput("use " + type);
                assertEquals("Error: data structure is empty", this.uv.processInput("getFirst"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void getFirstOne(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("Test", this.uv.processInput("getFirst"));
            }

            @Nested
            class getFirstPV {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use pv");
                }

                @Test
                void getFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test3", this.uv.processInput("getFirst"));
                }

                @Test
                void getFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    assertEquals("Test10", this.uv.processInput("getFirst"));
                }
            }

            @Nested
            class getFirstSK {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use sk");
                }

                @Test
                void getFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test3", this.uv.processInput("getFirst"));
                }

                @Test
                void getFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    assertEquals("Test9", this.uv.processInput("getFirst"));
                }
            }

            @Nested
            class getFirstBST {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use bst");
                }

                @Test
                void getFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test1", this.uv.processInput("getFirst"));
                }

                @Test
                void getFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    assertEquals("Test5", this.uv.processInput("getFirst"));
                }
            }

            @Nested
            class getFirstBK {
                SeznamiUV uv;

                @BeforeEach
                void setUp() {
                    this.uv = new SeznamiUV();
                    this.uv.processInput("use bk");
                }

                @Test
                void getFirstThree() {
                    assertEquals("OK", this.uv.processInput("add Test1"));
                    assertEquals("OK", this.uv.processInput("add Test2"));
                    assertEquals("OK", this.uv.processInput("add Test3"));
                    assertEquals("Test3", this.uv.processInput("getFirst"));
                }

                @Test
                void getFirstMany() {
                    int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                    for (int i = 0; i < numbers.length; i++)
                        assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                    assertEquals("Test10", this.uv.processInput("getFirst"));
                }
            }
        }

        @Nested
        class size {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void sizeEmpty(String type) {
                this.uv.processInput("use " + type);
                assertEquals("0", this.uv.processInput("size"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void sizeOne(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("1", this.uv.processInput("size"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void sizeMany(String type) {
                this.uv.processInput("use " + type);
                int[] numbers = {5, 10, 2, 6, 7, 1, 8, 3, 4, 9};
                for (int i = 0; i < numbers.length; i++)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(numbers[i])));
                assertEquals(String.valueOf(numbers.length), this.uv.processInput("size"));
            }
        }

        @Nested
        class depth {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void depthEmpty(String type) {
                this.uv.processInput("use " + type);
                assertEquals("0", this.uv.processInput("depth"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void depthOne(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                if (type.equals("bst"))
                    assertEquals("0", this.uv.processInput("depth"));
                else
                    assertEquals("1", this.uv.processInput("depth"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bk"})
            void depthMany(String type) {
                this.uv.processInput("use " + type);
                int[] numOfElements = {5, 10, 20, 50};
                for (int i: numOfElements)
                    this.depthSub(type, i);
            }

            void depthSub(String type, int numOfElements) {
                int[] numbers = this.genNRandomNumbers(numOfElements);
                for (int number : numbers)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(number)));
                switch (type) {
                    case "pv" ->
                            assertEquals(String.valueOf((int) (Math.log(numOfElements) / Math.log(2)) + 1), this.uv.processInput("depth"));
                    case "sk" -> assertEquals(String.valueOf(numOfElements), this.uv.processInput("depth"));
                    case "bk" -> {
                        String binarno = Integer.toBinaryString(numOfElements);
                        assertEquals(String.valueOf(Math.pow(2, binarno.length())), this.uv.processInput("depth"));
                    }
                }
            }

            int[] genNRandomNumbers(int n) {
                int[] numbers = new int[n];
                for (int i = 0; i < n; i++)
                    numbers[i] = (int) (Math.random() * n);
                return numbers;
            }

            @Test
            void depthManyBST() {
                this.uv.processInput("use bst");
                int[] nums = {10, 6, 22, 4, 8, 18, 30, 5, 13, 19, 11, 15, 20};
                for (int num : nums)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(num)));
                assertEquals("5", this.uv.processInput("depth"));
            }
        }

        @Nested
        class isEmpty {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void isEmptyFalse(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("false", this.uv.processInput("isEmpty"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void isEmptyTrue(String type) {
                this.uv.processInput("use " + type);
                assertEquals("true", this.uv.processInput("isEmpty"));
            }
        }

        @Nested
        class remove {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void removeEmptyString(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("Error: please specify a string", this.uv.processInput("remove"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void removeNonExisting(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test1"));
                assertEquals("Error: element not found", this.uv.processInput("remove Test2"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void removeEmpty(String type) {
                this.uv.processInput("use " + type);
                assertEquals("Error: data structure is empty", this.uv.processInput("remove Test"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void removeOne(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("Test", this.uv.processInput("remove Test"));
                assertEquals("true", this.uv.processInput("isEmpty"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void removeMany(String type) {
                this.uv.processInput("use " + type);
                int[] nums = {10, 6, 22, 4, 8, 18, 30, 5, 13, 19, 11, 15, 20};
                for (int num : nums)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(num)));
                for (int num : nums)
                    assertEquals("Test" + String.valueOf(num), this.uv.processInput("remove Test" + String.valueOf(num)));
                assertEquals("true", this.uv.processInput("isEmpty"));
            }
        }

        @Nested
        class exists {
            SeznamiUV uv;

            @BeforeEach
            void setUp() {
                this.uv = new SeznamiUV();
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsEmptyString(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("Error: please specify a string", this.uv.processInput("exists"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsFalse(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test1"));
                assertEquals("false", this.uv.processInput("exists Test2"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsTrue(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("true", this.uv.processInput("exists Test"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsManyFalse(String type) {
                this.uv.processInput("use " + type);
                int[] nums = {10, 6, 22, 4, 8, 18, 30, 5, 13, 19, 11, 15, 20};
                for (int num : nums)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(num)));
                assertEquals("false", this.uv.processInput("exists Test50"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsManyTrue(String type) {
                this.uv.processInput("use " + type);
                int[] nums = {10, 6, 22, 4, 8, 18, 30, 5, 13, 19, 11, 15, 20};
                for (int num : nums)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(num)));
                assertEquals("true", this.uv.processInput("exists Test18"));
            }
        }
    }
}