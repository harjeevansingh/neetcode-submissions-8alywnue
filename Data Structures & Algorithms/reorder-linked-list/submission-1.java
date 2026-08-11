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

    ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode reversedRest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedRest; 
    }

    void merge(ListNode head, ListNode secondHead){
        while (head != null && secondHead != null){
            ListNode headNext = head.next;
            ListNode secondHeadNext = secondHead.next;
            head.next = secondHead;
            secondHead.next = headNext;
            head = headNext;
            secondHead = secondHeadNext;
        }
    }

    public void reorderList(ListNode head) {

        // 2. Optimised

            if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);

        merge(head, secondHalf);

        // 1. Non optimised


        // ArrayList<ListNode> nodeArray = new ArrayList<>();

        // ListNode temp = head;
        // while(temp != null){
        //     nodeArray.add(temp);
        //     temp = temp.next;
        // }

        // int length = nodeArray.size();
        // int left = 0, right = nodeArray.size() - 1;

        // while (left < right) {
        //     nodeArray.get(left).next = nodeArray.get(right);
        //     left++;

        //     if (left == right) break;

        //     nodeArray.get(right).next = nodeArray.get(left);
        //     right--;
        // }

        // nodeArray.get(left).next = null;
        
    }
}
