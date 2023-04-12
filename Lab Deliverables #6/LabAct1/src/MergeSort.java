public class MergeSort {

    public static void ascendingSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelperAscend(arr, 0, n - 1, temp);
    }

    public static int[] descendingSort(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i != -1; i--, j++)
            temp[j] = arr[i];

        return temp;
    }

    private static void mergeSortHelperAscend(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelperAscend(arr, left, mid, temp);
            mergeSortHelperAscend(arr, mid + 1, right, temp);
            mergeAscend(arr, left, mid, right, temp);
        }
    }

    private static void mergeAscend(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (i = left; i <= right; i++)
            arr[i] = temp[i];
    }
}
