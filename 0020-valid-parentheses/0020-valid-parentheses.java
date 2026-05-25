class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        if(n==1)
        return false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            st.push(s.charAt(i));
            else
            if(s.charAt(i)==')'){
                if(st.isEmpty()){
                    return false;
                }
            char v=st.pop();
            if(v!='(')
            return false;
            }
            else
            if(s.charAt(i)=='}'){
                if(st.isEmpty()){
                    return false;
                }
            char v=st.pop();
            if(v!='{')
            return false;
            }
            else
            if(s.charAt(i)==']'){
                if(st.isEmpty()){
                    return false;
                }
            char v=st.pop();
            if(v!='[')
            return false;;
            }
        }
        if(st.isEmpty())
        return true;
        else
        return false;
    }
}