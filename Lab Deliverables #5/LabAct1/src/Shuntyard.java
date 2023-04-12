import java.util.Stack;

public class Shuntyard {
    public Shuntyard() {
    }


    private static int precedence(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public static String algorithm(String expression) {
        Stack<Character> fixed = new Stack<>();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ')
                continue;

            if (Character.isLetterOrDigit(c))
                fixed.push(c);
            else if (c == '(')
                stk.push(c);
            else if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(')
                    fixed.push(stk.pop());

                if (!stk.isEmpty() && stk.peek() != '(')
                    throw new InternalError("Invalid Expression!");
                else
                    stk.pop();
            } else {
                while (!stk.isEmpty() && precedence(c) <= precedence(stk.peek()))
                    fixed.push(stk.pop());
                stk.push(c);
            }
        }

        return fixed.toString();
    }
}
