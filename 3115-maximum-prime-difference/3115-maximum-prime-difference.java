class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int n=nums.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        boolean prime = true;
            for(int i=0;i<n;i++)
            {
                if(isPrime(nums[i])){
                    if(mini==Integer.MAX_VALUE)
                    mini=i;
                maxi=i;
                }
            }
        int dist=maxi-mini;
        return dist;
    }
     private boolean isPrime(int num){
            if(num<=1)
            return false;
            int c=2;
            while(c*c<=num){
                if(num%c==0){
                return false;
                }
                c++;
                }
            return true;
     }
}