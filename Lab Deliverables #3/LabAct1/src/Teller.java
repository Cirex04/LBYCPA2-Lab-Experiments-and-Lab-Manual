import java.util.Arrays;

/**
 * @brief Blueprint for a teller class
 */
public class Teller<E> {
    /**
     * properties
     */
    private final int DEFAULT_SIZE = 10;
    private String teller;
    private E[] customers;
    private int ptr;

    /**
     * constructors
     */
    public Teller() {
        customers = (E[]) new Object[DEFAULT_SIZE];
        ptr = -1;
    }

    public Teller(String tellers) {
        customers = (E[]) new Object[DEFAULT_SIZE];
        this.teller = tellers;
        ptr = -1;
    }

    public Teller(int size) {
        this.customers = (E[]) new Object[size];
        ptr = -1;
    }

    /**
     * behaviors
     */
    public void add(Object element) {
        customers[++ptr] = (E) element;
    }

    public E access(int element) {
        return customers[element];
    }

    public E peek() {
        return customers[ptr];
    }

    public int getSize() {
        return ptr + 1;
    }

    public E[] getCustomers() {
        return customers;
    }

    public void setCustomers(E[] customers) {
        this.customers = customers;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public String printTeller() {
        return teller;
    }

    @Override
    public String toString() {
        return Arrays.toString(customers);
    }
}
