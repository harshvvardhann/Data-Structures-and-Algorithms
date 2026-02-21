class Solution {
    public boolean isShippeble(int capacity, int weights[], int days) {
        int requiredDays = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (w > capacity)
                return false;
            if (currentLoad + w > capacity) {
                requiredDays++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }

        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
            left = Math.max(left, weights[i]);
        }
        int ans = -1;
        while (left <= right) {
            int mid = (left + (right - left) / 2);
            if (isShippeble(mid, weights, days)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}