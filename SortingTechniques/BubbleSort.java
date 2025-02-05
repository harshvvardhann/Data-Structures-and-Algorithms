/**
 * The BubbleSort class in Java implements the bubble sort algorithm to sort an array of integers.
 */
package SortingTechniques;

public class BubbleSort {

    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount = 1;
                }
            }
            if (swapCount == 0) {
                break;
            }
            System.out.println("Hello");
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 12, 68, 2, 9, 1 };
        int newarr[] = sort(arr);
        for (Integer a : newarr) {
            System.out.println(a);
        }
    }
}
