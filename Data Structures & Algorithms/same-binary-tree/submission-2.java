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
    // public LinkedList<Integer> getPreOrder(TreeNode tree){

    // }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        System.out.println("p = " + (p != null ? p.val : "null") + ", q = " + (q != null ? q.val : "null"));
        if(p == null && q == null){
            return true;
        } else if(p == null || q == null){
            return false;
        }

        if(p.val != q.val || !isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)){
            return false;
        } 

        return true;

    }
}
