class Solution {
    public boolean isPalindrome(String s) {
        // in this we got a space complexity of O(n) because we used to lower case method on an entire string, so for storing that a new string has to be generated as strings are immutable, instaed in second method we will use lower case method at individual character while comparing only
    //    int l=0;
    //    int r=s.length()-1;
    //    s=s.toLowerCase();
    //    while(l<r){
    //     char a=s.charAt(l);
    //     char b=s.charAt(r);
    //     if(!Character.isLetterOrDigit(a)){
    //         l++;
    //         continue;
    //     }
    //     if(!Character.isLetterOrDigit(b)){
    //         r--;
    //         continue;
    //     }
    //     if(a!=b){
    //         return false;
    //     }
    //     l++;
    //     r--;
    //    }
    //    return true;


    int l=0;
       int r=s.length()-1;
       while(l<r){
        char a=Character.toLowerCase(s.charAt(l));
        char b=Character.toLowerCase(s.charAt(r));
        if(!Character.isLetterOrDigit(a)){
            l++;
            continue;
        }
        if(!Character.isLetterOrDigit(b)){
            r--;
            continue;
        }
        if(a!=b){
            return false;
        }
        l++;
        r--;
       }
       return true;
    }
}