import java.util.LinkedList;

public class Main {
    private static String josephus(int n, int k) {
        LinkedList<Integer> problem = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            problem.add(i);

        int index = 0;
        while (problem.size() > 1) {
            index = (index + k - 1) % problem.size();
            problem.remove(index);
        }

        return problem.get(0).toString();
    }

    public static void main(String[] args) {
        System.out.println(josephus(1231, 3));
    }
}