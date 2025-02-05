package SortingTechniques;

public class QuickSort {

    public static int sort(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            // find first element which is > pivot
            while (arr[i] <= pivot && i <= high - 1) {// so that it doesn't cross the boundary
                i++;
            }
            // find first element which is <pivot
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];  
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp1 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp1;
        return j;// returning the partition index
    }

    public static void quicksort(int arr[], int low, int high) {
        if (low < high) {// else array will be sorted
            int partition = sort(arr, low, high);
            sort(arr, low, partition - 1);
            sort(arr, partition + 1, high);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 2, 8, 1, 86, 34, 6, 11 };
        int low = 0;
        int high = arr.length - 1;
        quicksort(arr, low, high);
    }
}
