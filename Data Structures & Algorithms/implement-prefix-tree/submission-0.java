class TreeNode{
    public HashMap<Character, TreeNode> children;
    public boolean endOfWord;

    public TreeNode(){
        children = new HashMap<>();
    }
}

class PrefixTree {

    private TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode current = root;
        for(char c: word.toCharArray()){
            if(current.children.containsKey(c)){
                current = current.children.get(c);
            } else{
                TreeNode child = new TreeNode();
                current.children.put(c, child);
                current = child;
            }
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TreeNode current = root;
        for(char c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            } else{
                current = current.children.get(c);
            }
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = root;
        
        for(char c: prefix.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            } else{
                current = current.children.get(c);
            }
        }
        return true;
    }
}
