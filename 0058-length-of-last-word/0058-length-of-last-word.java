class Solution {
    public int lengthOfLastWord(String s) {
        int l=s.length()-1;
        int r=l;
        int len=0;
        while(r>=0&&s.charAt(r)==' '){//since extra space bhi ho skti last mei like the second exacmple isiliye loop tab tak chalao jab sbse first word from right side nhi mil jata
            r--;
            l=r;//mark l as the ending of the last word
        }
        while(r>=0&&s.charAt(r)!=' '){//now we will find the first letter index of that last word by looking for space after this word ends, and save it in r
           r--;
        }
        len=l-r;//word end -word start
        return len;
    }
    //TC_O(N),SC_O(1);

}
