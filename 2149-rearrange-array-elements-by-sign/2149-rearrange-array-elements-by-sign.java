class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int k=0;
        int l=1;
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
            ans[k]=nums[i];
            k+=2;
            }
            if(nums[i]<0){
                ans[l]=nums[i];
                l+=2;
            }
        }
        for(int j=0;j<n;j++){
         nums[j]=ans[j];
        }
        return nums;
    }
}