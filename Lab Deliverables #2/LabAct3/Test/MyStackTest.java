import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        MyStack myStack = new MyStack();
        Stack stack = new Stack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(stack.size(), myStack.size());
    }

    @Test
    void pop() {
        MyStack myStack = new MyStack();
        Stack stack = new Stack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(stack.size(), myStack.size());

        stack.push(3);

        assertNotEquals(stack.size(), myStack.size());
    }

    @Test
    void top() {
        MyStack myStack = new MyStack();
        Stack stack = new Stack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        myStack.pop();
        stack.pop();

        assertEquals(stack.peek(), myStack.top());

        myStack.pop();
        assertNotEquals(stack.peek(), myStack.top());
    }

    @Test
    void isEmpty() {
        MyStack myStack = new MyStack();
        Stack stack = new Stack();

        stack.push(1);
        myStack.push(1);
        stack.pop();
        myStack.pop();

        assertEquals(stack.isEmpty(), myStack.isEmpty());

        stack.push(1);
        myStack.push(1);

        assertEquals(stack.isEmpty(), myStack.isEmpty());
    }

    @Test
    void isFull() {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        assertTrue(myStack.isFull());

        myStack.pop();

        assertFalse(myStack.isFull());

        myStack.push(3);

        Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            myStack.push(3);
        });

        assertEquals("Index 3 out of bounds for length 3", e.getMessage());
    }
}