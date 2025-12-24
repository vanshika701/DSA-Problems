class Solution {
    public int myAtoi(String s) {
        int sign=1;
        int r=0;
        int k=0;
        int t=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                t++;
            }
            else
            {
                break;
            }
        }
        if(t<s.length()&&(s.charAt(t)=='-'||s.charAt(t)=='+')){
            if(s.charAt(t)=='-'){
            sign=-1;}
        t++;
        }
        for(int i=t;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
            k=s.charAt(i)-'0';
            if(r>Integer.MAX_VALUE/10||(r==Integer.MAX_VALUE/10&&   k>7)){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            r=r*10+k;
            }
            else
            {
                break;
            }
        }
        return r*sign;
    }
}