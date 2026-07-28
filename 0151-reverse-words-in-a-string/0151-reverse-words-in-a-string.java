class Solution {
    public String reverseWords(String s) {
       int i=s.length()-1;
       int end=s.length()-1;
       StringBuilder sb=new StringBuilder("");
       while(i>=0){
       while(i>=0&&s.charAt(i)==' '){//tab tk decrease kro jb tk word na mil jaye taki sare rare spaces skip ho sake
        i--;
       }
       if (i < 0)
    break;
        end=i;
       while(i>=0&&s.charAt(i)!=' '){//ab pura word extract krn eke lie tb tk chlao jb tk space na mil jaye, isse end and i index ke beech mei ek word pura extract ho jaega
        i--;
       }
       String str=s.substring(i+1,end+1);
       if (sb.length() > 0)
        sb.append(" ");
       sb.append(str);//ab bass wo word string mei append krte jao taki last wala word sbse aage aajaye
       //and ye if isliye hai taki last word ke baad space na aaye
       }
       return sb.toString();
    }
}