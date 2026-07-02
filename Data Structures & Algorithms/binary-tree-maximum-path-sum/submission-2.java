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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPathSumHelper(root);

        return max;
    }

    public int maxPathSumHelper(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);

        int maxOfSubtree = Math.max(leftSum, rightSum);
        int maxOfSplitOrNot = Math.max(root.val, root.val + maxOfSubtree);

        max =   Collections.max(Arrays.asList(
            max, maxOfSplitOrNot, leftSum+rightSum+root.val
        ));

        return maxOfSplitOrNot;

    }

}
