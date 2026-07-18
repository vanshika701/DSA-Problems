class Solution {
    public int lengthOfLongestSubstring(String s) {
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
