package TwopointeSlidingWindow;

class MaxPointsObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for(int i=0;i<k;i++){
            total += cardPoints[i];
        }

        int maxSum = total;
        int n = cardPoints.length;
        for(int j=0;j<k;j++){
            total = total - cardPoints[k-j-1] + cardPoints[n-j-1];
            maxSum = Math.max(maxSum,total);
        }
        return maxSum;
    }
}