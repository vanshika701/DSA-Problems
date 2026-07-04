class Solution {
    public boolean isSubsequence(String s, String t) {
        int ss=0;
        int st=0;
        char c=' ';
        while(ss<s.length()&&st<t.length()){
            c=s.charAt(ss);
            if(t.charAt(st)!=c)
            st++;
            else{
                st++;
                ss++;
            }
        }
        if(ss==s.length())
        return true;
        else
        return false;
    }
}