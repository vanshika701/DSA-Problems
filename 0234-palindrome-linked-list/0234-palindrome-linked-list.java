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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev=null;
        ListNode pres=slow.next;
        slow.next = null; 
        while(pres!=null){
            ListNode next = pres.next;
            pres.next=prev;
            prev=pres;
            pres=next;
        }
        fast=head;
        while(prev!=null){
            if(fast.val!=prev.val) return false;
                fast=fast.next;
                prev=prev.next;

        }
        return true;
    }
}