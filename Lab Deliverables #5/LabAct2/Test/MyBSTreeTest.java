import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBSTreeTest {

    @Test
    public void insert() {
        MyBSTree<Integer> bst = new MyBSTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);

        assertEquals("5 3 1 7 9", bst.toString());
    }

    @Test
    public void contains() {
        MyBSTree<String> bst = new MyBSTree();
        bst.insert("apple");
        bst.insert("banana");
        bst.insert("orange");
        bst.insert("pear");

        assertTrue(bst.contains("apple"));
        assertTrue(bst.contains("banana"));
        assertTrue(bst.contains("orange"));
        assertTrue(bst.contains("pear"));
        assertFalse(bst.contains("grape"));
    }

    @Test
    public void remove() {
        MyBSTree<Integer> bst = new MyBSTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);

        bst.remove(5);
        assertEquals("7 3 1 9", bst.toString());

        bst.remove(7);
        assertEquals("9 3 1", bst.toString());

        bst.remove(1);
        assertEquals("9 3", bst.toString());

        bst.remove(9);
        assertEquals("3", bst.toString());

        bst.remove(3);
        assertEquals("", bst.toString());
    }

    @org.junit.jupiter.api.Test
    void inorderTraversal() {
    }

    @org.junit.jupiter.api.Test
    void preorderTraversal() {
    }

    @org.junit.jupiter.api.Test
    void postorderTraversal() {
    }
}