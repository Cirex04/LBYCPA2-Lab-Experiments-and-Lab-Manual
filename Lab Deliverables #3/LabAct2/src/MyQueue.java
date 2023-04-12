import java.util.Arrays;

public class MyQueue<E> implements QueueInterface {
    private final int MAX = 10;
    private E[] buffer;
    private int size, head, tail;

    public MyQueue() {
        buffer = (E[]) new Object[MAX];
        head = 0;
        tail = 0;
        size = 0;
    }

    public MyQueue(int size) {
        this.buffer = (E[]) new Object[MAX];
        head = 0;
        tail = 0;
        this.size = size;
    }

    @Override
    public void push(Object item) {
        if (size == MAX) {
            System.out.println("Queue is full");
            return;
        }

        buffer[tail] = (E) item;
        tail = (tail + 1) % MAX;
        size++;
    }

    @Override
    public Object pop() {
        if (!empty()) {
            Object result = buffer[head];
            head = (head + 1) % MAX;
            size--;
            return result;
        } else
            throw new RuntimeException("Empty Queue!");
    }

    @Override
    public Object front() {
        return buffer[head];
    }

    @Override
    public Object back() {
        if (!empty()) {
            return buffer[(tail - 1 + MAX) % MAX];
        } else
            throw new IllegalStateException("Queue is empty!");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(buffer);
    }
}