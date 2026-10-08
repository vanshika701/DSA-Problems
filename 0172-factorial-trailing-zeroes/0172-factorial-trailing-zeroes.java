class Solution {
    public int trailingZeroes(int n) {
        int k=5;
        int zero=0;
        while(k<=n){
            zero+=Math.floor(n/k);
            k*=5;
        }
        return zero;
    }
}