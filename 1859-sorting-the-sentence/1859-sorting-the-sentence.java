class Solution {
    public String sortSentence(String s) {
        int p=0;
        int l=s.length();
        String[] arr=new String[10];
        for(int i=0;i<l;i++){
            if(s.charAt(i)==' '){
                int k=s.charAt(i-1)-'0';
                arr[k]=s.substring(p,i-1);
                p=i+1;
            }
        }
        int k=s.charAt(l-1)-'0';
        arr[k]=s.substring(p,l-1);
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<10;i++){
            if(arr[i]!=null){
            if(sb.length()>0)
            sb.append(" ");
            sb.append(arr[i]);
               }
        }

        return sb.toString();
    }
}