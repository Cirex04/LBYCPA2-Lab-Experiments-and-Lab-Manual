import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @org.junit.jupiter.api.Test
    void push() {
        MyQueue<Integer> test = new MyQueue<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);

        int actual = (int) test.front();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void pop() {
        MyQueue<Integer> test = new MyQueue<>();
        test.push(1);
        test.push(2);
        test.pop();

        int actual = (int) test.pop();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void front() {
        MyQueue<Integer> test = new MyQueue<>();
        test.push(2);
        test.push(1);
        test.push(3);

        int actual = (int) test.front();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void back() {
        MyQueue<Integer> test = new MyQueue<>();
        test.push(1);
        test.push(2);
        test.push(3);

        test.pop();

        int actual = test.back();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void size() {
        MyQueue<Integer> test = new MyQueue<>();
        test.push(1);
        test.push(1);
        test.push(1);
        test.push(1);

        int actual = test.size();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void empty() {
        MyQueue<Integer> test = new MyQueue<>();
        test.push(1);

        boolean actual = test.empty();

        assertFalse(actual);

        test.pop();

        actual = test.empty();

        assertTrue(actual);
    }
}