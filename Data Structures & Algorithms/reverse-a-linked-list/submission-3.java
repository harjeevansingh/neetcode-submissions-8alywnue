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
    public ListNode reverseList(ListNode head) {

        // Recursion
        // if(head == null){
        //     return null;
        // }

        // ListNode reversedList = reverseList(head.next);
        // if(reversedList == null){
        //     return head;
        // }
        // head.next.next = head;
        // head.next = null;
        // return reversedList;


        // Iterative
        ListNode prev = null;

        while(head !=null){
            ListNode temp = head.next; // next is here
            head.next = prev; // current node points to previous
            prev = head; // prev is set to current node 
            head = temp; // head is not the next node
        }

        return prev;
        
    }
}
