package Arrays.Medium;
import java.util.Arrays;

class largestNumber {
    public static String largestNumber1(int[] nums) {
        // Convert int array to String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator: Concatenate and compare
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number after sorting is "0", return "0"
        if (strNums[0].equals("0")) return "0";

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        int arr[] = {3,30,34,5,9};
        String ans = largestNumber1(arr);
        System.out.println(ans);
    }
}