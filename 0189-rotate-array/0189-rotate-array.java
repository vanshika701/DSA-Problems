class Solution {
    public void rotate(int[] nums, int k) {
        k=nums.length-(k%(nums.length));
        int temp[]=new int[k];
        for(int i=0;i<k;i++){
            temp[i]=nums[i];
        }
        for(int i=0;i<nums.length-k;i++){
            nums[i]=nums[i+k];
        }
        for(int i=0;i<k;i++)
        {
            nums[nums.length-k+i]=temp[i];
        }
    }
}