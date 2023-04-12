import java.util.Stack;

public class Main {
    private static int precedence(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    private static Stack postfix(String expression) {
        Stack<Character> print = new Stack<>();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetterOrDigit(c))
                print.push(c);
            else if (c == '(')
                stk.push(c);
            else if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(')
                    print.push(stk.pop());

                if (!stk.isEmpty() && stk.peek() != '(')
                    throw new InternalError("Invalid Expression!");
                else
                    stk.pop();
            } else {
                while (!stk.isEmpty() && precedence(c) <= precedence(stk.peek()))
                    print.push(stk.pop());
                stk.push(c);
            }
        }

        return print;
    }

    private static Stack prefix(String expression) {
        Stack<Character> print = new Stack<>();
        Stack<Character> temp = new Stack<>();
        Stack<Character> stk = new Stack<>();

        for (int i = expression.length() - 1; i > -1; i--) {
            char c = expression.charAt(i);
            if (Character.isLetterOrDigit(c))
                temp.push(c);
            else if (c == ')')
                stk.push(c);
            else if (c == '(') {
                while (!stk.isEmpty() && stk.peek() != ')')
                    temp.push(stk.pop());

                if (!stk.isEmpty() && stk.peek() != ')')
                    throw new InternalError("Invalid Expression!");
                else
                    stk.pop();
            } else {
                while (!stk.isEmpty() && precedence(c) < precedence(stk.peek()))
                    temp.push(stk.pop());
                stk.push(c);
            }
        }

        while (!temp.empty())
            print.push(temp.pop());

        return print;
    }

    public static void main(String[] args) {
        String expression = "((A+B*C)+((D*E+F)*G))";
//        String expression = "(A^B+C)";
        System.out.println("Postfix: " + postfix(expression));
        System.out.println("Prefix: " + prefix(expression));
    }
}