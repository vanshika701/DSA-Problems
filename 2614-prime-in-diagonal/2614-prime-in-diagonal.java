class Solution {
    public int diagonalPrime(int[][] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j||i+j==nums.length-1){
                    if(isPrime(nums[i][j]))
                    {
                        if(max<nums[i][j])
                        max=nums[i][j];
                    }
                }
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