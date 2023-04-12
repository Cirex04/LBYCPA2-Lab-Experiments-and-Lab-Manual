public class InsertionSort {
    public static void insertionSort(int[] arr, int length) {
        int i, j, key;
        for (j = 1; j < length; j++) {
            key = arr[j];
            for (i = j - 1; (i >= 0) && (key < arr[i]); i--)
                arr[i + 1] = arr[i];
            arr[i + 1] = key;
        }
    }
}