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
    public boolean validatationHelper(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        
        if(root.val <= left || root.val >= right){
            return false;
        }

        return (validatationHelper(root.left, left, root.val) &&
        validatationHelper(root.right, root.val, right));
    }
    public boolean isValidBST(TreeNode root) {
        return validatationHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
