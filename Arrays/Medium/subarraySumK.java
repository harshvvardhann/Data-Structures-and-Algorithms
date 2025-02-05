package Arrays.Medium;
import java.util.HashMap;

public class subarraySumK {
    public static int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1 };
        int k = 2;
        System.out.println(subarraySum(arr, k));
    }
}
