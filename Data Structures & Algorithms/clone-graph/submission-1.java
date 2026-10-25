/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneHelper(Node node, HashMap<Node, Node> cloneMap){
        if(node == null){
            return node;
        }

        Node cloneNode = cloneMap.get(node);

        if(cloneNode != null){
            return cloneNode;
        } else {
            cloneNode = new Node(node.val);
            cloneMap.put(node, cloneNode);
        }

        for(Node neighbor: node.neighbors){
            Node clonedneighbor = cloneHelper(neighbor, cloneMap);
            cloneNode.neighbors.add(clonedneighbor);
        }

        return cloneNode;
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cloneMap = new HashMap<>();
        Node cloneNode = cloneHelper(node, cloneMap);
        return cloneNode;
       
    }
}