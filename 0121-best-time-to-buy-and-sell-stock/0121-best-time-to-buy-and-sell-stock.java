class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            int cost=prices[i]-min;
            if(cost>profit)
            profit=cost;
            if(prices[i]<min)
            min=prices[i];
        }
        return profit;
    }
}