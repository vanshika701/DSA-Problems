class Solution {
    public int hammingWeight(int n) {
        int c=0;
        int d=0;
        while(n>0){
            d=n%2;
            if(d==1)
            c++;
            n=n/2;
        }
        return c;
    }
}