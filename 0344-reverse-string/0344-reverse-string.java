class Solution {
    public void reverseString(char[] s) {
        int b=0;
        int l=s.length-1;
        for(b=0;b<l;b++){
            char temp=s[l];
            s[l]=s[b];
            s[b]=temp;
            l--;
        }
    }
}