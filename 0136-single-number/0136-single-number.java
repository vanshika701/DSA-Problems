class Solution {
    public int singleNumber(int[] nums) {
        int c=0,found=0;
        for(int i=0;i<nums.length;i++){
            int k=nums[i];
            for(int j=0;j<nums.length;j++){
                if(k==nums[j]){
                c++;
                }
            }
            if(c==1){
            found = k;
            break;}
            else{
            c=0;
            }
        }
        return found;
    }
}