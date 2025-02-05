package SortingTechniques;

public class SelectionSort {
    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    int temp = arr[j];
                    arr[j] = arr[min];
                    arr[min] = temp;
                }
            }
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
