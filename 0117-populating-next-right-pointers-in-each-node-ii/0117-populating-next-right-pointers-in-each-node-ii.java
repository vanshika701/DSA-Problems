/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //will be done using BFS
        if(root==null)
        return null;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
            Node currNode=queue.poll();
            if(i==levelSize-1)
            currNode.next=null;
            else
            currNode.next=queue.peek();
            if(currNode.left!=null)
            queue.add(currNode.left);
            if(currNode.right!=null)
            queue.add(currNode.right);
            }
        }
        return root;
    }
}