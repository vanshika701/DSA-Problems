class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            int sum=0;
            while(n>0){
                int d=n%10;
                sum+=(d*d);
                n=n/10;
            }
            n=sum;
        }
        return n==1;
    }
}
/*### Approach: HashSet Cycle Detection

Use a `HashSet` to store numbers encountered during the process. Repeatedly calculate the sum of the squares of the digits using `% 10` to extract each digit and `/ 10` to remove it.

Replace `n` with this sum and repeat until `n` becomes `1` or a previously seen number is encountered. If `n == 1`, return `true`; otherwise, a cycle exists, so return `false`.

**Time Complexity:** O(m × d), where `m` is the number of transformations and `d` is the maximum number of digits processed per transformation.

**Space Complexity:** O(m) for storing previously seen numbers in the HashSet.*/