public class SelectionSort {
    public static void selectionSort(int[] arr, int length) {
        int i, j, min;
        int min_at;
        for (i = 0; i < (length - 1); i++) {
            min = arr[i];
            min_at = i;
            for (j = i + 1; j < length; j++) {
                if (min > arr[j]) {
                    min = arr[j]; //update minimum
                    min_at = j; // index of minimum
                }
            }
            //swap minimum and first element of the array
            int temp = arr[i];
            arr[i] = arr[min_at];
            arr[min_at] = temp;
        }

    }
}
