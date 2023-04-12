import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack myStack(int n) {
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> newStk = new Stack<>();
        int ptr = -1;
        while (n != 0) {
            stk.push(n % 2);
            n /= 2;
            ptr++;
        }

        while (ptr > -1) {
            newStk.push(stk.pop());
            ptr--;
        }

        return newStk;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter int: ");
        int n = scanner.nextInt();
        System.out.println(myStack(n));
    }
}