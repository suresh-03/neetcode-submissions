class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] maxSuffixArr = new int[n];

        int maxSuffix = prices[n-1];

        for(int i = n-1; i >= 0; i--){
            maxSuffixArr[i] = maxSuffix;
            maxSuffix = Math.max(maxSuffix,prices[i]);
        }

        int maxProfit = 0;

        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit,maxSuffixArr[i]-prices[i]);
        }

        return maxProfit;
    }
}
