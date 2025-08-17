package ContestProblems.ContestProblems;

class BestTimeToBuyAndSellStockUsingStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        //initial profit
        long baseSum = 0;
        for(int i=0;i<n;i++){
            baseSum += (long) prices[i] * strategy[i];
        }

        //force to 0 and 1
        long stockIfHold[] = new long[n];
        long stockIfSell[] = new long[n];
        for(int j=0;j<n;j++){
            stockIfHold[j] = (0L - strategy[j]) * prices[j];
            stockIfSell[j] = (1L - strategy[j]) * prices[j];
        }

        //take the 1st k bunch and calculate the profit
        int half = k/2;
        long leftSum = 0L;
        long rightSum = 0L;
        for(int i=0;i<k/2;i++) leftSum += stockIfHold[i];
        for(int j=k/2;j<k;j++) rightSum += stockIfSell[j];

        long bestDelta = leftSum + rightSum;

        //loop over remaining k-length bunch to find max profit  
        for(int L=1;L+k-1<n;L++){
            int outLeft = L - 1;
            int outRight = L - 1 + half;
            int inLeft = L - 1 + half;
            int inRight = L + k - 1;

            leftSum -= stockIfHold[outLeft];
            leftSum += stockIfHold[inLeft];

            rightSum -= stockIfSell[outRight];
            rightSum += stockIfSell[inRight];

            bestDelta = Math.max(bestDelta,leftSum + rightSum);
        }

        return baseSum + Math.max(0L,bestDelta);
    }
}
