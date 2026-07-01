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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null){
            return null;
        }

        if(preorder.length == 0){
            return null;
        }

        TreeNode currentNode = new TreeNode(preorder[0]);

        if(preorder.length == 1){
            return currentNode;
        }

        int length = preorder.length;
        int root = preorder[0];
        int lengthOrLeftSuBtree = 0;
        for(int i=0;i<length;i++){
            if(inorder[i] == root){
                lengthOrLeftSuBtree = i;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, lengthOrLeftSuBtree+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, lengthOrLeftSuBtree);

        int[] rightPreorder = Arrays.copyOfRange(preorder, lengthOrLeftSuBtree+1, length);
        int[] rightInorder = Arrays.copyOfRange(inorder, lengthOrLeftSuBtree+1, length);

        TreeNode leftSubTree = buildTree(leftPreorder, leftInorder);
        TreeNode rightSubTree = buildTree(rightPreorder, rightInorder);

        currentNode.left = leftSubTree;
        currentNode.right = rightSubTree;

        return currentNode;
        
    }
}
