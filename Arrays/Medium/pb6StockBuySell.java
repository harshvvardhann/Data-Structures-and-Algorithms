package Arrays.Medium;

public class pb6StockBuySell {
    public static int stockbuysell(int[] nums) {
        int buy = Integer.MAX_VALUE;
        int sell = 0; // Initialize sell to 0

        for (int i = 0; i < nums.length; i++) {
            buy = Math.min(buy, nums[i]);// 7//1//1
            sell = Math.max(sell, nums[i] - buy);// 0//0//4//5
        }

        return sell;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 4, 3, 1 };
        System.out.println(stockbuysell(arr));
    }
}
