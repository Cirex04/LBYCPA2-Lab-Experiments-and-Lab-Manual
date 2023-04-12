import java.time.Duration;
import java.time.Instant;

public class TimeDuration {
    // Algorithm that takes time
    static int Fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    static void mergeSort(int n) {
        int[] test = new int[n];
        for (int i = n, j = 0; j < n; i--, j++)
            test[j] = i;
        MergeSort.ascendingSort(test);
    }

    static void quickSort(int n) {
        int[] test = new int[n];
        for (int i = n, j = 0; j < n; i--, j++)
            test[j] = i;
        Quicksort.ascending(test, 0, n - 1);
    }

    static void selectionSort(int n) {
        int[] test = new int[n];
        for (int i = n, j = 0; j < n; i--, j++)
            test[j] = i;
        SelectionSort.selectionSort(test, n);
    }

    static void insertionSort(int n) {
        int[] test = new int[n];
        for (int i = n, j = 0; j < n; i--, j++)
            test[j] = i;
        InsertionSort.insertionSort(test, n);
    }

    static void bubbleSort(int n) {
        int[] test = new int[n];
        for (int i = n, j = 0; j < n; i--, j++)
            test[j] = i;
        BubbleSort.bubbleSort(test, n);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
//========================================================/
// Do something (use an algorithm that takes time)
//        selectionSort((int) Math.pow(2, 10));
//        insertionSort((int) Math.pow(2, 10));
//        bubbleSort((int) Math.pow(2, 10));
//        mergeSort((int) Math.pow(2, 10));
//        quickSort((int) Math.pow(2, 10));
//========================================================/
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time elapsed: " + timeElapsed.toMillis() + " ms");
    }
}