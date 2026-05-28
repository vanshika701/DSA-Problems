class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || 
            tokens[i].equals("-") ||
            tokens[i].equals("*") ||
            tokens[i].equals("/"))
            {
                int p=st.pop();
                int q=st.pop();
                if(tokens[i].equals("+"))
                st.push(q+p);
                else
                if(tokens[i].equals("-"))
                st.push(q-p);
                else
                if(tokens[i].equals("*"))
                st.push(p*q);
                else
                {if(p!=0)
                st.push(q/p);
                }
            }
            else
            {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}