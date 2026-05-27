class Solution {
    public int findPeakElement(int[] nums) {
        int l=nums.length;
        if(l==1)
        return 0;
        else
        if(nums[0]>nums[1])
        return 0;
        else 
        if(nums[l-1]>nums[l-2])
        return l-1;
        else{
        for(int i=1;i<l-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
            return i;
        }
        }
        return -1;
    }
}