class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=cardPoints.length-1;
        int r=k-1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=r;i++){
            sum+=cardPoints[i];
        }
        max=Math.max(max, sum);
        while(r>=0){
            sum-=cardPoints[r];
            r--;
            sum+=cardPoints[l];
            l--;
            max=Math.max(max, sum);
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}