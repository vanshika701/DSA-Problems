class Solution {
    public String reverseWords(String s) {
       int i=s.length()-1;
       int end=s.length()-1;
       StringBuilder sb=new StringBuilder("");
       while(i>=0){
       while(i>=0&&s.charAt(i)==' '){
        i--;
       }
       if (i < 0)
    break;
        end=i;
       while(i>=0&&s.charAt(i)!=' '){
        i--;
       }
       String str=s.substring(i+1,end+1);
       if (sb.length() > 0)
        sb.append(" ");
       sb.append(str);
       }
       return sb.toString();
    }
}