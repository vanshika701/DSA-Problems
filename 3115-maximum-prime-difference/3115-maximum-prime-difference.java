class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int n=nums.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            boolean prime = true;
            if(nums[i]==1)
            prime =false;
            int c=2;
            while(c*c<=nums[i]){
                if(nums[i]%c==0){
                prime=false;
                break;
                }
                c++;}
                if(prime){
                    if(i<mini)
                    mini=i;
                    if(i>maxi)
                    maxi=i;
                }
            }
        int dist=maxi-mini;
        return dist;
    }
}