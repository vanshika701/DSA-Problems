class Solution {
    public String reversePrefix(String word, char ch) {
        int l=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
            l=i+1;
            break;
            }
        }
        if(l==0)
        return word;
        int b=0;
        StringBuilder sb=new StringBuilder(word);
        String k=sb.substring(b,l);
        StringBuilder sb1=new StringBuilder(k);
        sb1.reverse();
        sb.replace(b,l,sb1.toString());
        return sb.toString();
    }
}