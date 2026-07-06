class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i++){
            int c=0;
            int k=i;
            while(k>0){
            if((k&1)==1)
            c++;
            k=k>>1;
            }
            ans[i]=c;
        }
        return ans;
    }
}