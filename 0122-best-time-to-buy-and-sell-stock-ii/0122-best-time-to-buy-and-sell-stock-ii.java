class Solution {
    public int maxProfit(int[] prices) {
        int totalProf=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                totalProf+=(prices[i+1]-prices[i]);
            }
            else
            continue;
        }
        return totalProf;
    }
}