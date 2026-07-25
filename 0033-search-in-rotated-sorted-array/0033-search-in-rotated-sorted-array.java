class Solution {
    public int search(int[] nums, int target) {
        //isme hum normally bin search nhi lga skte, isme hume subarrays mei jane se phle chcek krna padega ki konsa sorted hai we. will go into that, then we will check if our target is in this sorted half if it is then we can easily find else we have to search in the other side subarray
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
                else
                if(nums[start]<=nums[mid])//then we are sure that the left arrya is sorted
                {
                    if(target>=nums[start]&&target<nums[mid])
                    end=mid-1;
                    else
                    start=mid+1;
                }
                else{
                    if(target>nums[mid]&&target<=nums[end])
                    start=mid+1;
                    else
                    end=mid-1;
        }
        }
        return -1;
    }
}