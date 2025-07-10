class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        StringBuilder sb=new StringBuilder(String.valueOf(s.charAt(0)));
        int max=1;
        int len=s.length();
        for(int i=1;i<len;i++){
                if(sb.indexOf(String.valueOf(s.charAt(i))) == -1){
                sb.append(s.charAt(i));
                }
                else{
                int index = sb.indexOf(String.valueOf(s.charAt(i)));
                sb.delete(0, index + 1);
                sb.append(s.charAt(i));
                }
                if(max<sb.length()){
                max=sb.length();
                }
            }
        
            return max;
        }
    }
