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

 //this is correct but not the most optimal solution tc-O(n), but space is O(n) as we are using a list, if we werent using a list then sc would be O(logn)=O(h) due to inorder traversal storing members in stack
// class Solution {
//     TreeNode prev=null;
//     List<Integer> list=new ArrayList<>();
//     public boolean isValidBST(TreeNode root) {
//       helper(root);
//       for(int i=0;i<list.size()-1;i++){
//         if(list.get(i)<list.get(i+1))
//         continue;
//         else
//         return false;
//       }
//       return true;
//     }
//     public void helper(TreeNode root){
//          if(root==null)
//         return;
//         helper(root.left);
//         list.add(root.val);
//         helper(root.right);
//     }
// }


//this is more optimal as we did not use a list in this and the space compex is o(logn) , we used a pointer and inorder traversal in this and kept checking if the left most is smaller then the node and the right most
class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        return true;
    //isValidBST(root.left);
    if (!isValidBST(root.left))
    return false;
      if(prev!=null&&prev.val>=root.val)
      return false;
      prev=root;
      return isValidBST(root.right);
    }
}
