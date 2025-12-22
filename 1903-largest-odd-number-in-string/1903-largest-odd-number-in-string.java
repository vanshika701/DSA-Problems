class Solution {
    public String largestOddNumber(String num) {
        int l=num.length();
        String s="";
        for(int i=l-1;i>=0;i--){
            if((int)num.charAt(i)%2!=0)
            {
                s=num.substring(0,i+1);
                break;
            }
        }
        return s;
    }
}