package BASICS;

public class pb9ReverseArray {
    public static int[] reverseArray(int n, int[] nums) {
        // Write your code here.
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}