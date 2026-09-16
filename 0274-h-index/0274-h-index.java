class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int count[]=new int[n+1];
        int l=0;
        for(int i=0;i<n;i++){
            if(citations[i]>=n)
            l=n;
            else
            l=citations[i];
            count[l]++;
        }
        int papers=0;
        for(int i=n;i>=0;i--){
            papers+=count[i];
            if (papers >= i)
            return i;
        }
        return 0;
    }
}