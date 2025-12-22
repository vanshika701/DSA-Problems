class Solution {
    public int reverseDegree(String s) {
        int l=s.length()-1;
        int sum=0;
        for(int i=0;i<=l;i++){
            int b='z'-s.charAt(i)+1;
            sum+=(b*(i+1));
        }
        return sum;
    }
}