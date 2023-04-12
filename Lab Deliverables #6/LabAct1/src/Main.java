import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = new int[]{77,42,35,12,101,5,88,65};
        MergeSort.ascendingSort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(MergeSort.descendingSort(test)));
    }
}