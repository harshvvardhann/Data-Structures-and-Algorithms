package Arrays.Medium;

public class pb8NextPermutation {
    public static void reverse(int arr[], int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static int[] nextPermutation(int arr[]) {
        int index = -1;
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(arr, 0, arr.length - 1);
            return arr;
        } else {
            for (int i = arr.length - 1; i > index; i--) {
                if (arr[i] > arr[index]) {
                    swap(arr, i, index);
                    break;
                }
            }
            if (index + 1 < arr.length - 1) {
                reverse(arr, index + 1, arr.length - 1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 4, 3, 0, 0 };
        int nextPerm[] = nextPermutation(nums);
        System.out.print("[");
        for (Integer a : nextPerm) {
            System.out.print(a + ",");
        }
        System.out.print("]");
    }
}
