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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode resultTail = null;
        while(list1 != null && list2 != null){
            ListNode currentNode;
            if(list1.val < list2.val){
                currentNode = new ListNode(list1.val);
                list1 = list1.next;
            } else{
                currentNode = new ListNode(list2.val);
                list2 = list2.next;
            }

            if(result == null){
                result = currentNode;
                resultTail = currentNode;
            } else{
                resultTail.next = currentNode;
                resultTail = resultTail.next;
            }
        }
        if(list1 != null){
            if(result == null){
                return list1;
            }
            resultTail.next = list1;
        } else if(list2 != null){
            if(result == null){
                return list2;
            }
            resultTail.next = list2;
        }

        return result;
    }
}