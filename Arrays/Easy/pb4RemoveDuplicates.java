package Arrays.Easy;

public class pb4RemoveDuplicates {

    public static int[] removeDuplicates(int arr[]) {
        int j = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 4, 5, 6, 6, 7 };
        int arr1[] = removeDuplicates(arr);
        System.out.println(arr1);
    }
}
