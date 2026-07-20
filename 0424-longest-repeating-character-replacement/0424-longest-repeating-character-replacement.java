class Solution {
    public int characterReplacement(String s, int k) {
        //We use a **sliding window** with a frequency array to keep track of the count of each character in the current window. `maxFreq` stores the frequency of the most common character in the window. If `(window size - maxFreq) > k`, it means we need to replace more than `k` characters to make all characters in the window the same, so we shrink the window from the left. Otherwise, the window is valid, and we update the maximum length. Since each character is added and removed from the window at most once, the solution runs in **O(n)** time with **O(1)** extra space.

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