class Solution {
    public boolean isSubsequence(String s, String t) {
        int l1=0;
        int l2=0;
        while(l1<s.length()&&l2<t.length()){
            if(s.charAt(l1)==t.charAt(l2))
            {l1++;
            }
                l2++;
        }
        return l1==s.length();
}
}