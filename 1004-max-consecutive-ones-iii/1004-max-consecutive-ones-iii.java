class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int max=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]==1)
            {
                r++;
                max=Math.max(max,r-l);
            }
            else
            {
                if(k>0){
                k--;
                r++;
                max=Math.max(max,r-l);
                }
                else
                {
                    if(nums[l]==0)
                    k++;
                    l++;
                }
            }
        }
        return max;
    }
}