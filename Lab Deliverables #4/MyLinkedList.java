package mangunay.cj.portfoliov2;

/**
 * @brief My Linked list data structure
 */

public class MyLinkedList<E> implements MyLinkedListInterface {
    /**
     * properties
     */
    private int size;
    private Node head;

    /**
     * Node
     */
    private class Node {
        private Node next;
        private E data;

        private Node(E data) {
            next = null;
            this.data = data;
        }
    }

    /**
     * constructors
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * behaviors
     */

    @Override
    public void add(Object data) {
        Node newNode = new Node((E) data);

        if (isEmpty()) {
            newNode.next = null;
            head = newNode;
            ++size;
        } else
            add(size, data);

    }

    @Override
    public void add(int index, Object data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node newNode = new Node((E) data);

        if (isEmpty()) {
            newNode.next = null;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
                current = current.next;

            newNode.next = null;
            current.next = newNode;
        }

        ++size;
    }

    @Override
    public void set(int index, Object data) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (isEmpty())
            throw new IllegalStateException();
        else if (index == 0)
            head.data = (E) data;
        else {
            Node current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            current.data = (E) data;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node current = head;
        E removed = head.data;

        if (index == 0)
            head = head.next;
        else {
            for (int i = 0; i < index; i++)
                current = current.next;

            removed = current.data;
            current.next = current.next.next;
        }

        --size;
        return removed;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current.data;
    }

    @Override
    public E element() {
        return head.data;
    }

    @Override
    public boolean contains(Object data) {
        Node current = head;
        while (current.next != null) {
            if (current.data.equals(data))
                return true;

            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String printAll() {
        return null;
    }
}
