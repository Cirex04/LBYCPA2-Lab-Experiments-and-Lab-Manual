public class Main {
    private static MyStack<Boolean> truthValues;
    private static MyStack p;
    private static MyStack q;

    private static int precedence(String str) {
        return switch (str) {
            case "~" -> 1;
            case "^" -> 2;
            case "v" -> 3;
            case "=" -> 4;
            case "<" -> 5;
            case "⊻" -> 6;
            case "↑" -> 7;
            case "↓" -> 8;
            default -> -1;
        };
    }

    private static boolean operate(int n, boolean p, boolean q) {
        return switch (n) {
            case 2 -> and(p, q);
            case 3 -> or(p, q);
            case 4 -> cond(p, q);
            case 5 -> biCond(p, q);
            case 6 -> xor(p, q);
            case 7 -> nand(p, q);
            case 8 -> nor(p, q);
            default -> false;
        };
    }

    private static boolean operate(boolean p) {
        return not(p);
    }

    private static MyStack initializeP() {
        MyStack<Boolean> p = new MyStack<>(4);
        p.push(false);
        p.push(false);
        p.push(true);
        p.push(true);
        return p;
    }

    private static MyStack initializeQ() {
        MyStack<Boolean> q = new MyStack<>(4);
        q.push(false);
        q.push(true);
        q.push(false);
        q.push(true);
        return q;
    }

    private static MyStack convertPostfix(String expression) {
        MyStack<String> print = new MyStack<>(20);
        MyStack<String> stk = new MyStack<>(20);
        MyStack<Boolean> holdP = new MyStack<>(4);
        MyStack<Boolean> holdQ = new MyStack<>(4);
        MyStack<Boolean> holdPQ = new MyStack<>(4);
        String[] operator = {"~", "^", "v", "=>", "<->", "⊻", "↑", "↓"};
        truthValues = new MyStack<>(20);
        p = initializeP();
        q = initializeQ();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetter(c) && c != 'v')
                print.push(c);
            else if (precedence(String.valueOf(c)) == 1) {
                stk.push(print.pop());
                if (stk.top().toString().equals("p")) {
                    for (int j = 0; j < 4; j++)
                        holdPQ.push(operate((boolean) p.pop()));
                    for (int j = 0; j < 4; j++)
                        p.push(holdPQ.pop());
                } else if (stk.top().toString().equals("q")) {
                    for (int j = 0; j < 4; j++)
                        truthValues.push(operate((boolean) q.pop()));
                }

                String temp = operator[0] + stk.pop();
                print.push(temp);
            } else {
                for (int j = 2; j <= 8; j++) {
                    if (precedence(String.valueOf(c)) == j) {
                        stk.push(print.pop());
                        stk.push(print.pop());
                        String temp = "(" + stk.pop() + operator[j - 1] + stk.pop() + ")";
                        print.push(temp);
                    }
                }
            }
        }

        return print;
    }

    private static void toPrint(String expression) {
        boolean[][] pq = {
                {true, true, false, false},
                {true, false, true, false},
                {(boolean) truthValues.pop(), (boolean) truthValues.pop(), (boolean) truthValues.pop(), (boolean) truthValues.pop()}
        };

        System.out.printf("|%5s||%5s||%15s|\n", "p", "q", expression);
        for (int i = 0; i < 4; i++)
            System.out.printf("|%5s||%5s||%15s|\n", pq[0][i], pq[1][i], pq[2][i]);
    }

    public static boolean not(boolean p) {
        return !p;
    }

    public static boolean and(boolean p, boolean q) {
        return p && q;
    }

    public static boolean or(boolean p, boolean q) {
        return p || q;
    }

    public static boolean nand(boolean p, boolean q) {
        return !(p && q);
    }

    public static boolean nor(boolean p, boolean q) {
        return !(p || q);
    }

    public static boolean xor(boolean p, boolean q) {
        return p != q;
    }

    public static boolean cond(boolean p, boolean q) {
        return (!p || q);
    }

    public static boolean biCond(boolean p, boolean q) {
        return p == q;
    }

    public static void main(String[] args) {
//        String sample = "pq~^";
        String sample = "pq~vpq^=>";
        toPrint(convertPostfix(sample).pop().toString());
    }
}