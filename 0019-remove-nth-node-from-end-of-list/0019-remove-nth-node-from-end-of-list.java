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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //this node is not the most optimal solutoon for this because we had to traverse the list twice 
        // ListNode temp=head;
        // int i=1;
        // while(temp.next!=null){
        //     temp=temp.next;
        //     i++;
        // }
        // if(i==n)
        // return head.next;
        // int k=1;
        // temp=head;
        // while(k!=(i-n)){
        //    temp=temp.next;
        //    k++;
        // }
        // temp.next=temp.next.next;
        // return head;


        //the optimal solution is when we traverse the list onl yonce
        ListNode buffer=new ListNode(0);
        buffer.next=head;
        ListNode slow=buffer;
        ListNode fast=buffer;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return buffer.next;
    }
}

// ### Approach

// Use the **two-pointer technique** with a dummy node.

// * Create a dummy node before `head` to handle the case where the head itself needs to be removed.
// * Move `fast` pointer `n` steps ahead of `slow`.
// * Move both pointers together until `fast.next` becomes `null`. At this point, `slow` is positioned just before the node that needs to be removed.
// * Remove the node using `slow.next = slow.next.next`.
// * Return `dummy.next` as the new head.

// ### Complexity

// * **Time:** `O(L)`, where `L` is the length of the linked list.
// * **Space:** `O(1)`.
