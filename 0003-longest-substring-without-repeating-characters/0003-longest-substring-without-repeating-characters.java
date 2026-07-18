class Solution {
    public int lengthOfLongestSubstring(String s) {
        //The brute force to this would be to generate all the strings and chcek which is the longest not repeating char strings
        //in this the TC is O(N) becayse we traverse each element once 
        //SC O(min(n,k)) wheee n is the total no of char in the string and k is the number of distinct char in the string. Because the smaller one will decide how many keys is rhe hashmap going to store
        //map.getOrDefault(ch, 0)- this gets the value of the given key if its available in the hashmap and if its not available it gives 0 instead of giving null
        int n=s.length()-1;
        int l=0;
        int r=0;
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<=n){
            char ch=s.charAt(r);
            while ( map.getOrDefault(ch, 0)>0) {
                char chh=s.charAt(l);
                map.put(chh, map.getOrDefault(chh,0) - 1);
                l++;
            } 
            map.put(ch, map.getOrDefault(ch,0) + 1);
            r++;
            max=Math.max(max, r-l);
        }
        return max;
        }
    }
