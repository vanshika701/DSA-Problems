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
}// point to note is ek din mei multiple time khareed bech skte and tc-O(n) and sc-O(1)
//optimal approach
//approach hai ki jab bhi agle din stock k price badhne wala toh aad bech do basically short term investment