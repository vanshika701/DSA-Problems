class Solution {
    public int numberOfSubstrings(String s) {
        // toh basically hume string ko traverse karna hai and first teeno index ki location store krni hai and then agr wo teeno ki location update ho chuki hai toh it means a subdtring mei teeno hai, toh uss substring ko count krlo + min of all index nikalke usko bhi add krlo as all the othetr subarrays that will contain that minimal subarray
        
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
            count+=Math.min(a,Math.min(b,c))+1;
            }
            l++;
        }
        return count;
    }
}//tc-O(n)
//SC- O(1)