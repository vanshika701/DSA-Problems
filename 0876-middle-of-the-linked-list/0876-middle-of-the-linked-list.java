/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode n= head;
        ListNode m=head;
        while(n.next!=null&&n.next.next!=null){
            n=n.next.next;
            m=m.next;
        }
        if(n.next!=null)
        return m.next;
        else
        return m;
    }
}