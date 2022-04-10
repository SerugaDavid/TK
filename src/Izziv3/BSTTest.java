package Izziv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    BST<Integer> bst;

    @BeforeEach
    void setUp() {
        this.bst = new BST<>();
    }

//     testAdd()
    @Test
    void testAdd() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
    }

    @Test
    void testAddDuplicate() {
        bst.insert(5);
        assertThrows(InputMismatchException.class, () -> bst.insert(5));
    }

//     testRemoveFirst() ...
    @Test
    void testRemoveFirst() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.delete(5);
        assertEquals(2, bst.size());
    }

    @Test
    void testRemoveFirstEmpty() {
        assertThrows(InputMismatchException.class, () -> bst.delete(5));
    }


//     testGetFirst() ...
//     testSize() ...
//     testDepth() ...
//     testIsEmpty() ....
//     testExists() ...
//     testRemove()

}