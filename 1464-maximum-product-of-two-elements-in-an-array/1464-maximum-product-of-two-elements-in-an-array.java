class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
           if(nums[i]>=max){
           max1=max;
           max=nums[i];
        }
        else
        if(nums[i]>max1){
        max1=nums[i];
        }
        }
        int ans=(max-1)*(max1-1);
        return ans;
    }
}