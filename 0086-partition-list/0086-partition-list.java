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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        ListNode buffer=new ListNode();
        ListNode buff=buffer;
        while(head!=null){
            if(head.val<x)
            {
                curr.next=head;
                curr=curr.next;
            }
            else
            if(head.val>=x){
                buff.next=head;
                buff=buff.next;
            }
            head=head.next;
        }
        buff.next = null;
        curr.next=buffer.next;
        return dummy.next;
    }
}