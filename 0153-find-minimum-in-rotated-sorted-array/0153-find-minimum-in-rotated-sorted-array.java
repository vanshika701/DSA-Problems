class Solution {
    public int findMin(int[] nums) {//this solln is incorrect, because there is no way we would be able to handle the numsstart==numsmid case so this min var soln isnt valid
        // int start=0;
        // int end=nums.length-1;
        // int min=Integer.MAX_VALUE;;
        // while(start<=end){
        //     int mid=start+(end-start)/2;
        //     min=Math.min(min,nums[mid]);
        //     if(nums[start]<nums[mid])
        //     {
        //         min=Math.min(min, nums[start]);
        //     start=mid+1;
        //     }
        //     else
        //     if(nums[start]>nums[mid])
        //     {min=Math.min(min, nums[mid]);
        //     end=mid-1;}
        // }
        // return min;




        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[end]>nums[mid])
            end=mid;
            else
            start=mid+1;
        }
        return nums[start];
    }
}