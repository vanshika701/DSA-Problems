class Solution {
    public void rotate(int[] nums, int k) {
        //this soln didnt work for the testcase which had too many elements as it was not optimal and was exceeding time limit
        // int n=nums.length;
        // k=k%n;
        // int j=0;
        // int last=0;
        // while(j!=k){
        //     last=nums[n-1];
        //     for(int i=n-1;i>0;i--){
        //         nums[i]=nums[i-1];
        //     }
        //     nums[0]=last;
        //     j++;
        // }

        int i=0;
        int n=nums.length;
        k=k%n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
        public void reverse(int[] nums, int i, int n ){
            while(i<n){
            int temp=nums[i];
            nums[i]=nums[n];
            nums[n]=temp;
            n--;
            i++;
        }
        }
}