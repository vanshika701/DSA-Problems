class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //two pointer approach will be used
        //isme dono pointr ko left se start nhi krenge , ek ko left se and ke ko right se krnege and dono ka sum krenge agar sum bhut zyada hai toh r ko decrease krenge warna agar sum kam hua toh l ko increase krenge
        //TC- O(N)
        //SC-O(1)
        int l=0;
        int r=numbers.length-1;
        int[] ans=new int[2];
        int n=numbers.length;
        while(l<n&&r>=0){
            if(numbers[l]+numbers[r]==target){
                ans[0]=l+1;
                ans[1]=r+1;
                break;
            }
            else
            if(numbers[l]+numbers[r]<target){
                l++;
            }
            else
            if(numbers[l]+numbers[r]>target){
                r--;
            }
        }
        return ans;
    }
}