/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    int r=0;
    public int sumNumbers(TreeNode root) {
       helper(root);
       return sum;

    }
    public void helper(TreeNode root) {
     if (root == null)
        return;
        r=r*10+root.val;
        if(root.left==null&&root.right==null)
        sum+=r;
        helper(root.left);
        helper(root.right);
        r=r/10;
    }
}