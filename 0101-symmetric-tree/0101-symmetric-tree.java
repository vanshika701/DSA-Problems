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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
    return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
                TreeNode l=queue.poll();
                TreeNode r=queue.poll();
                if (l == null && r == null)
                continue;

                if (l == null || r == null)
                return false;

                if(l.val!=r.val)
                return false;

                        queue.add(l.left);
                        queue.add(r.right);
                        queue.add(l.right);
                        queue.add(r.left);
                }
        return true;
        }
}//bfs lgake  phle que mei left ka left pusg kro nd right ka right, then left ka right and right ka left, nd que se do do member nikal ke check krte rho both shld be equal