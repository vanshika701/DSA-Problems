class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1;
        int b=-1;
        int c=-1;
        int l=0;
        int count=0;
        int n=s.length();
        int r=-1;
        while(l<n){
            if(s.charAt(l)=='a')
            a=l;
            else
            if(s.charAt(l)=='b')
            b=l;
            else
            c=l;
            if(a!=-1&&b!=-1&&c!=-1){
                count++;
            r=Math.min(a,Math.min(b,c));
            if(r!=0){
                r--;
                while(r>=0){
                    count++;
                    r--;
                }
            }
            }
            l++;
        }
        return count;
    }
}