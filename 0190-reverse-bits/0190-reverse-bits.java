class Solution {
    public int reverseBits(int n) {
        int d=0;
        int r=0;
       for(int i=0;i<32;i++){
        d=n&1;
        r<<=1;
        r|=d;
        n=n>>1;
       }
       return r;
    }
}