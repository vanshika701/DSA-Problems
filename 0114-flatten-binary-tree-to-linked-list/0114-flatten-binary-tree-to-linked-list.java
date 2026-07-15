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
    public void flatten(TreeNode root) {

        //this is more optimal approach where the space complexoty is 0(1), we are just rewiring th epointers in this below
        if(root==null)
         return;
        if(root.left!=null){
            TreeNode curr=root.left;
            while(curr.right!=null){
                curr=curr.right;
            }
            curr.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        flatten(root.right);

    }
}
//the less optimal method takes O(N) Space as it uses a queue, we just do a preorder traversal using dfs and feed evrything into a queue , and then simply poll everything out of it and present in. a linkedlist