public class BubbleSort {
    public static void bubbleSort(int[] arr, int length) {
        boolean swapped = true;
        int i, j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (i = 0; i < length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
