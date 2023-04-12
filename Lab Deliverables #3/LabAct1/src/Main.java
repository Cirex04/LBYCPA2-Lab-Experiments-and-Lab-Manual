import java.io.FileNotFoundException;
import java.util.Objects;

public class Main {
    private static int max() throws FileNotFoundException {
        CustomerController customer = new CustomerController();
        int size = customer.getCustomers().size();
        int max = 0;

        for (int i = 0; i < size; i++) {
            int temp = Objects.requireNonNull(customer.getCustomers().poll()).getTransTime();
            if (max < temp)
                max = temp;
        }

        return max;
    }

    private static int initMin() throws FileNotFoundException {
        CustomerController customer = new CustomerController();
        int size = customer.getCustomers().size();
        int min = max();

        for (int i = 0; i < size; i++) {
            int temp = customer.getCustomers().poll().getTransTime();
            if (min > temp)
                min = temp;
        }

        return min;
    }

    private static int newMin(int[] customers) throws FileNotFoundException {
        int min = max();

        for (int temp : customers) {
            if (min > temp)
                min = temp;
        }

        return min;
    }

    private static void output(Teller<CustomerModel>[] tellers, int size) throws FileNotFoundException {
        int ptr = -1;
        for (Teller<CustomerModel> teller : tellers) {
            System.out.println(teller.printTeller());
            for (int j = 0; j < teller.getSize(); j++) {
                if (teller.peek() != null) {
                    System.out.printf("%d %s %s %c %.2f %.2f\n", teller.access(j).getOrderNum(),
                            teller.access(j).getAccNum(),
                            teller.access(j).getAccName(),
                            teller.access(j).getTransType(),
                            (float) teller.access(j).getTransAmount(),
                            (float) (teller.access(j).getTransType() == 'W' ? teller.access(j).getINITCASH() - teller.access(j).getTransAmount() : teller.access(j).getINITCASH() + teller.access(j).getTransAmount()));
                }
            }
        }
    }

    private static void solution(int size, Teller<CustomerModel>[] tellers,CustomerController customers) throws FileNotFoundException {
        int min = initMin();

        for (int i = 0; i < size + 1; i++) {
            int[] currentCustomers = new int[tellers.length];

            for (int j = 0; j < tellers.length; j++) {
                if (tellers[j].isEmpty()) {
                    tellers[j].add(customers.getCustomers().poll());
                    size--;
                } else {
                    if (tellers[j].peek().getTransTime() == min) {
                        tellers[j].add(customers.getCustomers().poll());
                        break;
                    }
                }
            }

            for (int j = 0; j < tellers.length; j++)
                currentCustomers[j] = tellers[j].peek().getTransTime();

            min = newMin(currentCustomers);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        CustomerController customers = new CustomerController();
        Teller<CustomerModel>[] tellers = new Teller[3];
        int size = customers.getCustomers().size();
        int printSize = size;

        for (int i = 0; i < tellers.length; i++)
            tellers[i] = new Teller<>("*************************\nTeller " + (i + 1) + " Transaction log\n");

        solution(size,tellers,customers);
        output(tellers, printSize);
    }
}
