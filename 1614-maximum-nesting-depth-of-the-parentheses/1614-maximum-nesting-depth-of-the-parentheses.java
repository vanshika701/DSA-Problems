class Solution {
    public int maxDepth(String s) {
        int bal=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            {
                bal++;
            }
            else 
            if(s.charAt(i)==')'){
                bal--;
            }
            if(bal>max)
            max=bal;
        }
        return max;
    }
}