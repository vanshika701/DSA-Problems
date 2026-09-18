class Solution {
    public int climbStairs(int n) {
        //recursion
        // if(n==0)
        // return 1;
        // if(n==1)
        // return 1;
        // return climbStairs(n-1)+climbStairs(n-2);
        /*### Approach: Recursion
        To reach step `n`, the last move can either be
        * 1 step from `n-1`
        * 2 steps from `n-2`
        Therefore: `ways(n) = ways(n-1) + ways(n-2)`
        Base cases:**
        * `n == 0 → 1` because there is one way to reach the top by taking no more steps.
        * `n == 1 → 1` because there is only one way to reach step 1.
        The recursion repeatedly breaks the problem into smaller staircases until reaching the base cases.
        **Time Complexity:** `O(2^n)` because many subproblems are calculated repeatedly.
        **Space Complexity:** `O(n)` due to the maximum depth of the recursion call stack.
        This is not a good soln because multiple subproblems are being solved again and again. therefore we ill do dp
        */

        //Memoization
        int[] dp=new int[n+1];
        return solve(n, dp);
    }
        public int solve(int n, int[] dp) {

        if (n == 0)
            return 1;

        if (n == 1)
            return 1;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

        return dp[n];
        }
    }
