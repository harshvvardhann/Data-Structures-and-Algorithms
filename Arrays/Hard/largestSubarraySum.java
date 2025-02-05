package Arrays.Hard;

import java.util.HashMap;

public class largestSubarraySum {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else {

                if (hm.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - hm.get(sum));
                } else {
                    hm.put(sum, i);
                }
            }
        }
        return maxLen;
    }
}
