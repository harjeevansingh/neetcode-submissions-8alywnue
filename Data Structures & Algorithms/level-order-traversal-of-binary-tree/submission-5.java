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
        Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> leveledNodes = new ArrayList<>();

            while(!queue.isEmpty()){
            
                int levelSize = queue.size();
                List<Integer> currentLevelNodes = new ArrayList<>();

                for(int i=0;i<levelSize;i++){
                    TreeNode currentNode = queue.poll();
                    if(currentNode != null){
                        currentLevelNodes.add(currentNode.val);
                        queue.add(currentNode.left);
                        queue.add(currentNode.right);
                    }
                }

                if(!currentLevelNodes.isEmpty())
                    leveledNodes.add(currentLevelNodes);
            }

            return leveledNodes;
    }

}
