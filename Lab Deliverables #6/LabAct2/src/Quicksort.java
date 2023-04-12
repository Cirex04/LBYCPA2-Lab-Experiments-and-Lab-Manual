public class Quicksort {

    // Sorts the input array in ascending order using Quicksort algorithm
//     Quicksort.ascending(arr, 0, arr.length - 1);
    public static void ascending(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionAscending(arr, low, high);
            ascending(arr, low, partitionIndex - 1);
            ascending(arr, partitionIndex + 1, high);
        }
    }

    // Partitions the array into two halves, with elements greater than the pivot on the right and elements smaller on the left
    private static int partitionAscending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Sorts the input array in descending order using Quicksort algorithm
    public static void descending(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionDescending(arr, low, high);
            descending(arr, low, partitionIndex - 1);
            descending(arr, partitionIndex + 1, high);
        }
    }

    // Partitions the array into two halves, with elements smaller than the pivot on the right and elements greater on the left
    private static int partitionDescending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swaps two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
