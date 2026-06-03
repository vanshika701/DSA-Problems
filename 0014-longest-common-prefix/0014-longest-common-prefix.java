class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder(strs[0]);
        int k=0;
        for(int i=1;i<strs.length;i++)
        {
            for(int j=0;j<Math.min(sb.length(), strs[i].length());j++){
            if(sb.charAt(j)!=strs[i].charAt(j))
            {
            sb.delete(j,sb.length());
            break;
            }
            }
            if(strs[i].length() < sb.length())
            sb.delete(strs[i].length(), sb.length());

            if(sb.length() == 0)
            return "";

        }
        return sb.toString();
    }
}