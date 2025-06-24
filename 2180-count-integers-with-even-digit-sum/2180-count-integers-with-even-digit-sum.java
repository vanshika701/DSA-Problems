class Solution {
    public int digitSum(int i) {
        int sum=0;
        while(i>0){
            sum+=(i%10);
            i=i/10;
        }
        return sum;
    }
    public int countEven(int num) {
        int sum=0;
        int c=0;
        for(int i=1;i<=num;i++){
        sum=digitSum(i);
        if(sum%2==0){
        c++;
        }
    }
    return c;
}
}