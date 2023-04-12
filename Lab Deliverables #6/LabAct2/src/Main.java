import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {77,42,35,12,101,5,88,65};

        // Sort the array in ascending order
        Quicksort.ascending(arr, 0, arr.length - 1);
        System.out.println("Sorted array in ascending order: " + Arrays.toString(arr));

        // Sort the array in descending order
        Quicksort.descending(arr, 0, arr.length - 1);
        System.out.println("Sorted array in descending order: " + Arrays.toString(arr));
    }

}