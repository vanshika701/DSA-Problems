class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            if(((int)sb.charAt(i)>122||(int)sb.charAt(i)<97)&&((int)sb.charAt(i)>'9'||(int)sb.charAt(i)<'0')){
                sb.deleteCharAt(i);
                i--;
            }
        }
        int p=sb.length()-1;
        int l=0;
        while(l<p){
           if(sb.charAt(p)==sb.charAt(l))
           {
            p--;
            l++;
           }
           else{
            return false;
           }
        }
        return true;
    }
}