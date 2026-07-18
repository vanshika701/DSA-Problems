class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //TC=O(N),SC=O(1), second best soln yet
        int r=0;
        int l=0;
        int sum=0;
        int min = Integer.MAX_VALUE;
        int n=nums.length;
        while(r<n){
                sum+=nums[r];
                r++;
            while(sum>=target){
                min=Math.min(min,r-l);
                sum-=nums[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;//If no subarray reaches target, min will still be:Integer.MAX_VALUE. The problem expects you to return 0.
    }
}