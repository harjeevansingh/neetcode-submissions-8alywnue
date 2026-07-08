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
        ListNode prev = null;

        while(head !=null){
            ListNode printHead = head;
            while(printHead!=null){
                System.out.print(printHead.val + ", ");
                printHead = printHead.next;
            }
            System.out.println();
            ListNode temp = head.next; // next is here
            System.out.print( "Temp = " + (temp != null ? temp.val : "-") + ", ");
            head.next = prev; // current node points to previous
            System.out.print( "head.next = " + (prev != null ? prev.val : "-") + ", ");
            prev = head; // prev is set to current node 
            System.out.print( "prev = " +  (prev != null ? prev.val : "-") + ", ");
            head = temp; // head is not the next node
            System.out.println( "head = " + (head != null ? head.val : "-"));

            printHead = head;
            while(printHead!=null){
                System.out.print(printHead.val + ", ");
                printHead = printHead.next;
            }

        }

        return prev;
        
    }
}
