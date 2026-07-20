class Solution {
    public boolean isPalindrome(String s) {
       int l=0;
       int r=s.length()-1;
       s=s.toLowerCase();
       while(l<r){
        char a=s.charAt(l);
        char b=s.charAt(r);
        if(!Character.isLetterOrDigit(a)){
            l++;
            continue;
        }
        if(!Character.isLetterOrDigit(b)){
            r--;
            continue;
        }
        if(a!=b){
            return false;
        }
        l++;
        r--;
       }
       return true;
    }
}