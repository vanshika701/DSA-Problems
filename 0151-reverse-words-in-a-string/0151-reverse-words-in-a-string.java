class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] parts=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=parts.length-1;i>=0;i--){
            if (sb.length() > 0) sb.append(" ");
            sb.append(parts[i]);
        }
        return sb.toString();
    }
}