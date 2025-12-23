class Solution {
    public String removeOuterParentheses(String s) {
        // int l=s.length();
        // String str=s.substring(1,l-1);
        // StringBuilder sb=new StringBuilder(str);
        // for(int i=0;i<l-1;i++){
        //     if(sb.charAt(i)=='('&&sb.charAt(i+1)!=')')
        //     sb.deleteCharAt(i);
        //     else
        //     if(sb.charAt(i)==' ')
        //     return sb.toString();
        // }
        // return sb.toString();
        int count=0;
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l-1;i++){
             if(s.charAt(i) == '('){
                if(count>0)
                {sb.append(s.charAt(i));
                }
                count++;
             }
             else
             {
                count--;
             if(count>0){
                sb.append(s.charAt(i));
             }
             }
        }
         return sb.toString();
    }
}