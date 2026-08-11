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
    public void reorderList(ListNode head) {
        ArrayList<ListNode> nodeArray = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            nodeArray.add(temp);
            temp = temp.next;
        }

        int length = nodeArray.size();
        int left = 0, right = nodeArray.size() - 1;

        while (left < right) {
            nodeArray.get(left).next = nodeArray.get(right);
            left++;

            if (left == right) break;

            nodeArray.get(right).next = nodeArray.get(left);
            right--;
        }

        nodeArray.get(left).next = null;
        
    }
}
