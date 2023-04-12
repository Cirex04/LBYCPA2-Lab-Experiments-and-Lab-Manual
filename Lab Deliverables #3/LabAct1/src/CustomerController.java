import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @brief A database of customers
 */

public class CustomerController {
    /**
     * properties
     */
    private CustomerModel customer;
    private Queue<CustomerModel> customers;

    /**
     * constructors
     */
    public CustomerController() throws FileNotFoundException {
        customers = new LinkedList<>();
        initialize();
    }

    /**
     * behaviors
     */
    public void initialize() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\src\\database.csv"));
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            customer = new CustomerModel(Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3].charAt(0),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]));
            customers.offer(customer);
        }
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public Queue<CustomerModel> getCustomers() {
        return customers;
    }

    public void setCustomers(Queue<CustomerModel> customers) {
        this.customers = customers;
    }
}
