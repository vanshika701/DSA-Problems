// class Solution {
//     public int climbStairs(int n) {
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
    // class Solution {
    // public int climbStairs(int n) {
    //     int[] dp=new int[n+1];
    //     return solve(n, dp);
    // }
    //     public int solve(int n, int[] dp) {

    //     if (n == 0)
    //         return 1;

    //     if (n == 1)
    //         return 1;

    //     if (dp[n] != 0)
    //         return dp[n];

    //     dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

    //     return dp[n];
    //     }
    // }
    /*### Approach: Memoization
The recursive solution has **overlapping subproblems**, meaning the same values are calculated repeatedly.
To optimize it, we use a `dp` array where `dp[i]` stores the number of ways to reach step `i`.
For each `n`, the last move can be either:
* 1 step from `n-1`
* 2 steps from `n-2`
So we use:
`ways(n) = ways(n-1) + ways(n-2)
Before calculating, we check if `dp[n]` already contains the answer. If it does, we return it directly. Otherwise, we calculate the result, store it in `dp[n]`, and return it.
**Time Complexity:** `O(n)` because each subproblem is calculated only once.
**Space Complexity:** `O(n)` for the `dp` array and `O(n)` recursion stack, giving `O(n)` overall auxiliary space.
*/


//Tabulation
class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// ### Approach: Tabulation

// Instead of using recursion, we solve the problem **bottom-up** using a DP array.
// `dp[i]` represents the number of ways to reach step `i`.

// The base cases are:

// * `dp[0] = 1`
// * `dp[1] = 1`

// For every step from `2` to `n`, the last move can be either 1 step or 2 steps, so:

// `dp[i] = dp[i-1] + dp[i-2]`

// Unlike memoization, tabulation does not use recursion. It directly calculates the DP states from the smallest subproblem to the final answer
// **Time Complexity:** `O(n)` because we iterate from `2` to `n`.
// **Space Complexity:** `O(n)` because we store the results in the `dp` array.
