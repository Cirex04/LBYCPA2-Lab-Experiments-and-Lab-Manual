import java.util.EmptyStackException;

public class MyStack<E> implements StackInterface {
    private int size;

    private Node top;

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public MyStack() {
        this.top = null;
        size = 0;
    }

    public MyStack(int size) {
        this.top = null;
        this.size = size;
    }

    @Override
    public void push(Object j) throws StackFullException {
        //#TODO: write your implementation
        Node newNode = new Node((E) j);
        newNode.next = top;
        top = newNode;
        ++size;
    }

    @Override
    public E pop() throws StackEmptyException {
        //#TODO: write your implementation
        if (isEmpty())
            throw new EmptyStackException();

        E data = top.data;
        top = top.next;
        --size;
        return data;
    }

    @Override
    public E top() throws StackEmptyException {
        //#TODO: write your implementation
        if (isEmpty())
            throw new EmptyStackException();

        return top.data;
    }

    @Override
    public boolean isEmpty() {
        //#TODO: write your implementation
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }
}