class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int pos[]=new int[(int)Math.ceil(n/2)];
        int neg[]=new int[(int)Math.ceil(n/2)];
        int k=0;
        int l=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
            pos[k]=nums[i];
            k++;
            }
            if(nums[i]<0){
                neg[l]=nums[i];
                l++;
            }
        }
        k=0;
        l=0;
        for(int j=0;j<n;j++){
            if(j%2==0){
            nums[j]=pos[k];
            k++;
            }
            else{
                nums[j]=neg[l];
                l++;
            }
        }
        return nums;
    }
}