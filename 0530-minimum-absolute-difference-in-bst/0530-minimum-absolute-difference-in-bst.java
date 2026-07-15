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
    List<Integer> list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            int diff=Math.abs(list.get(i)-list.get(i+1));
            if(diff<min)
            min=diff;
        }
        return min;
    }
    public void helper(TreeNode root){
        if(root==null)
        return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}