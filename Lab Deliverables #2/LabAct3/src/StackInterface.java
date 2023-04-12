public interface StackInterface<E> {
    void push(E j) throws StackFullException;

    Object pop() throws StackEmptyException;

    E top() throws StackEmptyException;

    boolean isEmpty();

    boolean isFull();

    int size();
}