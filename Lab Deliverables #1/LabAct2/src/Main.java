import java.util.Random;

public class Main {
    private static int findMaxNum(int n, int[] array) {
        int max_element = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] > max_element)
                max_element = array[i];
        }

        return max_element;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000) + 1;
            System.out.printf("input %d: %d ||", i + 1, array[i]);
            if (i % 10 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("Max Number: " + findMaxNum(array.length, array));
    }
}