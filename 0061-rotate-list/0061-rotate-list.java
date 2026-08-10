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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
        return head;
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0)
            return head;
       ListNode dummy=new ListNode(0);
       dummy.next=head;
       ListNode slow=dummy;
       ListNode fast=dummy;
       for(int i=0;i<k;i++){
        fast=fast.next;
       }
       while(fast.next!=null){
        slow=slow.next;
        fast=fast.next;
       }
       dummy.next=slow.next;
       slow.next=null;
        fast.next=head;
        return dummy.next;
    }


}