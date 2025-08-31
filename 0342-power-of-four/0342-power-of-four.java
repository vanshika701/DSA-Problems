class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0)
        return false;
        else{
            while(n!=0){
                if(n%4==0||n==1)
                n=n/4;
                else 
                return false;
            }
        }
        return true;
    }
}