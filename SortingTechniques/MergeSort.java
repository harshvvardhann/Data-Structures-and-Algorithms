package SortingTechniques;

import java.util.ArrayList;

public class MergeSort {
    public static int[] mergeSort(int arr[], int left, int mid, int right) {
        ArrayList<Integer> a = new ArrayList<>();
        int low = left;
        int high = mid + 1;

        while (low <= mid && high <= right) {
            if (arr[low] <= arr[high]) {
                a.add(arr[low]);
                low++;
            } else {
                a.add(arr[high]);
                high++;
            }
        }

        while (low <= mid) {
            a.add(arr[low]);
            low++;
        }

        while (high <= right) {
            a.add(arr[high]);
            high++;
        }

        System.out.println("Left" + left);
        System.out.println("right" + right);

        for (int i = left; i <= right; i++) {
            arr[i] = a.get(i - left);
        }

        return arr;
    }

    public static void merge_sor(int arr[], int left, int right) {
        if (left >= right) {// mostly it is left==right as if both are same means the array cannot be
                            // divided further but for saftey we have done left>=right
            return;
        }
        int mid = left + (right - left) / 2;
        merge_sor(arr, left, mid);
        merge_sor(arr, mid + 1, right);
        mergeSort(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int arr[] = { 23, 55, 1, 39, 99, 23, 5, 23, 77, 2930, 323 };
        int n = 11;
        merge_sor(arr, 0, n - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}