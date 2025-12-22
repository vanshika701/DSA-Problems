class Solution {
    public boolean rotateString(String s, String goal) {
        int l=s.length()-1;
        for(int i=0;i<=l;i++){
            s=s.substring(1,l+1)+s.substring(0,1);
            if(s.equals(goal))
            return true;
        }
        return false;
    }
}