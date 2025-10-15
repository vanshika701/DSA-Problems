class Solution {
    public int search(int[] nums, int target) {
        int front=0;
        int back=nums.length-1;
        int mid=0;
        while(front<=back){
            mid=(front+back)/2;
            if(nums[mid]>target)
            back=mid-1;
            else
            if(nums[mid]<target)
            front=mid+1;
            else
            if(nums[mid]==target)
            return mid;
        }
        return -1;
    }
}