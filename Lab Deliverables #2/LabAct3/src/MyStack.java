import java.util.Arrays;

public class MyStack<E> implements StackInterface {
    private final int DEFAULT_SIZE = 10;
    private int ptr;
    private E[] array;

    public MyStack() {
        array = (E[]) new Object[DEFAULT_SIZE];
        ptr = -1;
    }

    public MyStack(int size) {
        array = (E[]) new Object[size];
        ptr = -1;
    }

    @Override
    public void push(Object j) throws StackFullException {
        //#TODO: write your implementation
        array[++ptr] = (E) j;
    }

    @Override
    public Object pop() throws StackEmptyException {
        //#TODO: write your implementation
        if (!isEmpty()) {
            Object popped = array[ptr];
            array[ptr--] = null;
            return popped;
        } else
            return null;
    }

    @Override
    public Object top() throws StackEmptyException {
        //#TODO: write your implementation
        if (!isEmpty())
            return array[size() - 1];
        else
            return null;
    }

    @Override
    public boolean isEmpty() {
        //#TODO: write your implementation
        return (ptr == -1);
    }

    @Override
    public boolean isFull() {
        //#TODO: write your implementation
        return (ptr == array.length - 1);
    }

    @Override
    public int size() {
        return ptr + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    public int getPtr() {
        return ptr;
    }

    public void setPtr(int ptr) {
        this.ptr = ptr;
    }

    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }
}