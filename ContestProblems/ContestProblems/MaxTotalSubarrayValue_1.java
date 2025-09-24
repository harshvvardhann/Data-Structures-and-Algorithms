package ContestProblems.ContestProblems;

class MaxTotalSubarrayValue_1 {
    public long maxTotalValue(int[] nums, int k) {
        int[] sormadexin = nums;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int x : sormadexin) {
            maxVal = Math.max(maxVal, x);
            minVal = Math.min(minVal, x);
        }

        long maxDiff = (long)maxVal - (long)minVal;
        return maxDiff * k;
    }
}