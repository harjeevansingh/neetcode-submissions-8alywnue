class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int left = 0;
        int right = 1;

        int profit = 0;

        while(right < prices.length){
            profit = Math.max(profit, prices[right]-prices[left]);

            if(prices[right]<prices[left]){
                left = right;
            }

            right++;
        }

        return profit;
    }
}
