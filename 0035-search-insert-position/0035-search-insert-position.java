class Solution {
    public int searchInsert(int[] nums, int target) {
        int lower=0;
        int end=nums.length-1;
        int mid=0;
        while(lower<=end){
            mid=lower+(end-lower)/2;
            if(nums[mid]==target)
            return mid;
            else
            if(nums[mid]>target){
            end=mid-1;
            }
            else{
            lower=mid+1;
            }
            }
            return lower;
    }
}