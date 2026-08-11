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
    public boolean hasCycle(ListNode head) {

        // 1. Hashset solution

        // HashSet<ListNode> set = new HashSet<>();
        // while(head != null){
        //     System.out.println("Head - " + head.val);
        //     set.stream().forEach(val -> System.out.print(val + ", "));
        //     System.out.println();
        //     if(set.contains(head)){
        //         return true;
        //     } else {
        //         set.add(head);
        //     }
        //     head = head.next;
        // }
        // return false;

        // 2. Fast & slow pointer

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;

    }
}
