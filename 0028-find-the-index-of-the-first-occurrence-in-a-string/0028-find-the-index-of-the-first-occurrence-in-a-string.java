class Solution {
    public int strStr(String haystack, String needle) {
        int l1=needle.length();
        int i=0;
        if(needle.length()>haystack.length())
        return -1;
        while(l1<=haystack.length()){
            String str=haystack.substring(i,l1);
            if(str.equals(needle))
            return i;
            else
            {
                l1++;
                i++;
            }
        }
        return -1;
    }
}
