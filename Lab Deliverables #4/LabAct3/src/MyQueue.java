import java.util.Arrays;

public class MyQueue<E> implements QueueInterface {
    private int size;
    private Node front;
    private Node rear;

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public MyQueue(int size) {
        front = null;
        rear = null;
        this.size = size;
    }

    @Override
    public void push(Object item) {
        Node newNode = new Node((E) item);

        if (empty())
            front = newNode;
        else
            rear.next = newNode;

        rear = newNode;
        rear.next = front;
        ++size;
    }

    @Override
    public Object pop() {
        E data = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        return data;
    }

    @Override
    public E front() {
        return front.data;
    }

    @Override
    public E back() {
        return rear.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return front == null || front == rear;
    }
}