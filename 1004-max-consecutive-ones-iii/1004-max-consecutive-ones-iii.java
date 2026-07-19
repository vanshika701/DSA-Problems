class Solution {
    public int longestOnes(int[] nums, int k) {
        //So each element is processed at most:once when r enters it,once when l leaves it.
        //Total operations are proportional to:n+n=2n
        //Ignoring constants:O(n)
	// ​int l=0;
    //     int r=0;
    //     int max=0;
    //     int n=nums.length;
        // while(r<n){
        //     if(nums[r]==1)
        //     {
        //         r++;
        //         max=Math.max(max,r-l);
        //     }
        //     else
        //     {
        //         if(k>0){
        //         k--;
        //         r++;
        //         max=Math.max(max,r-l);
        //         }
        //         else
        //         {
        //             if(nums[l]==0)
        //             k++;
        //             l++;
        //         }
        //     }
        // }
        // return max;

        //this soln has same tc nd sc
        int r=0;
        int max=0;
        int n=nums.length;
        int l=0;
        int zero=0;
        while(r<n){
            if(nums[r]==0){
                zero++;
            }
            while(zero>k){
                if(nums[l]==0){
                    zero--;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}