package Arrays.Easy;

public class pb11ConsecutiveOnes {

    // TC: O(N) SC:O(1)
    public static int maxconsecutiveOnes(int arr[]) {
        int maxCount = 0;
        int count = 0;

        // TC: O(N)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1 };
        System.out.println(maxconsecutiveOnes(arr));
    }
}
