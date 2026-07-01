class Solution {
    public int diagonalPrime(int[][] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
                    if(isPrime(nums[i][i]))
                    {
                        if(max<nums[i][i])
                        max=nums[i][i];
                    }
                    if(isPrime(nums[i][nums.length-i-1])){
                         max = Math.max(max, nums[i][nums.length - 1 - i]);
                    }
                }
        return max;
    }
    private boolean isPrime(int n){
        if(n<=1)
        return false;
        int c=2;
        while(c*c<=n){
            if(n%c==0){
            return false;
            }
            c++;
        }
        return true;
    }
}