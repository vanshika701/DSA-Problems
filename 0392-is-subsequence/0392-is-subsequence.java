class Solution {
    public boolean isSubsequence(String s, String t) {
        int ss=0;
        int st=0;
        char c=' ';
        while(ss<s.length()&&st<t.length()){
            if(t.charAt(st)!=s.charAt(ss))
            st++;
            else{
                st++;
                ss++;
            }
        }
        return ss==s.length();
    }
}