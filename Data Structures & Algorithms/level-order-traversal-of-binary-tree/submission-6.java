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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> currentLevel = new LinkedList<>();

            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();

                if(node != null){
                    currentLevel.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(currentLevel.size()>0){
                result.add(currentLevel);
            }
        }
        return result;
        
    }
}
