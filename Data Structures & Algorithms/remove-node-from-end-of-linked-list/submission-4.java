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

    int recursive(ListNode head, int n){
        if(head == null){
            return n;
        }
        int result = recursive(head.next, n);
        if(result == 0){
            if(head.next != null){
                head.next = head.next.next;
            } 
            return -1;
        } else if(result == -1){
            return -1;
        }

        return result-1;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        int result = recursive(head, n);
        if(result == 0){
            head = head.next;
        }
        return head;

    }
}
