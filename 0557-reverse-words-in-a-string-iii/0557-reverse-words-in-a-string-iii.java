class Solution {
    public String reverseWords(String s) {
       int l=s.length();
       int k=0;
       char temp=' ';
       StringBuilder sb=new StringBuilder(s);
       for(int i=0;i<l;i++){
        if(sb.charAt(i)==' '||i==l-1){
            int j=k;
            int p=(i==l-1)?i:i-1;
            while(j<p){
                temp=sb.charAt(j);
                sb.setCharAt(j,sb.charAt(p));
                sb.setCharAt(p,temp);
                j++;
                p--;
            }
            k=i+1;
            
        }
       } 
       return sb.toString();
    }
}