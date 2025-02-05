package Arrays.Easy;

public class pb5RotateArray {

    public static int[] rotate(int arr[], int left, int right, int k) {
        reverse(arr, left, right);
        reverse(arr, left, k - 1);
        reverse(arr, k, right);

        return arr;
    }

    public static void reverse(int arr[], int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int newarr[] = rotate(arr, 0, arr.length - 1, 3);
        for (Integer a : newarr) {
            System.out.println(a);
        }
    }
}
