class Solution {
    public int minimumPushes(String word) {
        int l=word.length();
        int push=0;
        int k=8;
        int p=1;
        while(l>0){
            l-=1;
            push+=(p*1);
            k++;
            int s=k/8;
            p=s;
        }
        return push;
    }
}