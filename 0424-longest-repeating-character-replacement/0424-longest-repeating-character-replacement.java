class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int n=s.length()-1;
        int maxArray=0;
        int maxLength=0;
        int[] hash=new int[26];
        while(r<=n){
            hash[s.charAt(r)-'A']++;
            maxArray=Math.max(maxArray,hash[s.charAt(r)-'A']);
            while((r-l+1)-maxArray>k){
            hash[s.charAt(l)-'A']--;
            l++;
            }
            if((r-l+1)-maxArray<=k){
                maxLength=Math.max(maxLength,r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}