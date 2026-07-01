/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public ArrayList<Integer> kthSmallestHelper(TreeNode root) {
        if(root == null){
           return new ArrayList<Integer>(); 
        }

        ArrayList<Integer> smallestListLeft = kthSmallestHelper(root.left);
        ArrayList<Integer> smallestListRight = kthSmallestHelper(root.right);
        smallestListLeft.add(root.val);
        smallestListLeft.addAll(smallestListRight);
        return smallestListLeft;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> smallestList = kthSmallestHelper(root);
        return smallestList.get(k-1);
    }
}
