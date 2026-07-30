class Solution {
    public boolean canJump(int[] nums) {
     int l=nums.length;
     int max=0;
     for(int i=0;i<l;i++){
        if (i > max)
        return false;
        max=Math.max(max,i+nums[i]);
        if(max >= l - 1)
        return true;
     }
     return true;
    }
}