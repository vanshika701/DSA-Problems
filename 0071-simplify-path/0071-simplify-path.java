class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        String part[]=path.split("/");
        for(int i=0;i<part.length;i++){
            if(part[i].equals("")||part[i].equals("."))
            continue;
            else
            if(part[i].equals(".."))
            {
                if(!stack.isEmpty())
                stack.pop();
            }
            else
            stack.push(part[i]);
        }
        StringBuilder sb=new StringBuilder();
        if(stack.isEmpty()){
            sb.append("/");
        }
        else{
        for(String dir : stack){
           sb.append("/"+dir);
        }
        }
        return sb.toString();
    }
}