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
        // Queue<TreeNode> queue = new LinkedList<>();
        //     queue.add(root);
        //     List<List<Integer>> leveledNodes = new ArrayList<>();

        //     while(!queue.isEmpty()){
        //         StringBuilder stringB = new StringBuilder();
        //         queue.stream().forEach(queueEle -> {
        //             stringB.append(queueEle !=null ? queueEle.val : "");
        //         });
        //         System.out.println("queue 1 - " + stringB);

        //         int levelSize = queue.size();
        //         System.out.println("levelSize - " + levelSize);
        //         List<Integer> currentLevelNodes = new ArrayList<>();

        //         for(int i=0;i<levelSize;i++){
        //             TreeNode currentNode = queue.poll();
        //             System.out.println("currentNode - " + currentNode);
        //             if(currentNode != null){
        //                 currentLevelNodes.add(currentNode.val);
        //                 queue.add(currentNode.left);
        //                 queue.add(currentNode.right);
        //             }
        //             System.out.println("currentLevelNodes - " + currentLevelNodes.toString());
        //         }

        //         if(!currentLevelNodes.isEmpty())
        //             leveledNodes.add(currentLevelNodes);
        //     }

        //     return leveledNodes;

         List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (level.size() > 0) {
                res.add(level);
            }
        }
        return res;
    }

}
