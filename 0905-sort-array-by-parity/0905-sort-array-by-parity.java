class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
            {
                int temp=nums[k];
                nums[k]=nums[i];
                nums[i]=temp;
                k++;
            }
        }
        return nums;
    }
}