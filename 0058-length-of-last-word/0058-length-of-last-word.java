class Solution {
    public int lengthOfLastWord(String s) {
        int l=s.length()-1;
        int r=l;
        int len=0;
        while(r>=0&&s.charAt(r)==' '){
            r--;
            l=r;
        }
        while(r>=0&&s.charAt(r)!=' '){
           r--;
        }
        len=l-r;
        return len;
    }
}
