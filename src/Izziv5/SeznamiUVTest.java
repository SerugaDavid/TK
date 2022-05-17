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
                String expected = "OK";
                assertEquals(expected, this.uv.processInput("add Test"));
                if (structure.equals("bst"))
                    expected = "Error: element already exists";
                assertEquals(expected, this.uv.processInput("add Test"));
                assertEquals(expected, this.uv.processInput("add Test"));
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
            void existsEmpty(String type) {
                this.uv.processInput("use " + type);
                assertEquals("Error: data structure is empty", this.uv.processInput("exists Test"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsFalse(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test1"));
                assertEquals("Element does not exist in data structure", this.uv.processInput("exists Test2"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsTrue(String type) {
                this.uv.processInput("use " + type);
                assertEquals("OK", this.uv.processInput("add Test"));
                assertEquals("Element exists in data structure", this.uv.processInput("exists Test"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsManyFalse(String type) {
                this.uv.processInput("use " + type);
                int[] nums = {10, 6, 22, 4, 8, 18, 30, 5, 13, 19, 11, 15, 20};
                for (int num : nums)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(num)));
                assertEquals("Element does not exist in data structure", this.uv.processInput("exists Test50"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"pv", "sk", "bst", "bk"})
            void existsManyTrue(String type) {
                this.uv.processInput("use " + type);
                int[] nums = {10, 6, 22, 4, 8, 18, 30, 5, 13, 19, 11, 15, 20};
                for (int num : nums)
                    assertEquals("OK", this.uv.processInput("add Test" + String.valueOf(num)));
                assertEquals("Element exists in data structure", this.uv.processInput("exists Test18"));
            }
        }
    }
}