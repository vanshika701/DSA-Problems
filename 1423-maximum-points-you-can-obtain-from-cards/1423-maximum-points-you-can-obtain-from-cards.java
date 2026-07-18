class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //so what we do is basically phle consider kro sare k cards ka sum starting se k cards se lelia and usko max manlo and then ek element ka sum remove krdo from the rear end of the initial subarray(at r) and r ko decraese krdo and summ mei ek element peeche se add krdo, and also decraese l--,  and tab tak kro ye jab tk r does not become 0
        int l=cardPoints.length-1;
        int r=k-1;
        int sum=0;
        for(int i=0;i<=r;i++){
            sum+=cardPoints[i];
        }
       int max=sum;
        while(r>=0){
            sum-=cardPoints[r];
            r--;
            sum+=cardPoints[l];
            l--;
            max=Math.max(max, sum);
        }
        return max;
    }
}