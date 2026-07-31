class Solution {
    public int jump(int[] nums) {
        int max=0;
        int n=nums.length;
        int l=0;
        int r=0;
        int jump=0;
        while(r<n-1){
            max=0;
            for(int i=l;i<=r;i++){
                max=Math.max(max,i+nums[i]);
            }
            l=r+1;
            jump+=1;
            r=max;
        }
        return jump;
    }
}