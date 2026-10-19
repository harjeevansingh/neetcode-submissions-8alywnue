class Node{
    HashMap<Character, Node> children;
    boolean isEnding;

    public Node(){
        children = new HashMap<>();
    }
}
class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node(); 
    }

    public void addWord(String word) {
        Node current = root;
        for(char c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new Node());
            }
            current = current.children.get(c);
        }
        current.isEnding = true;
    }

     public boolean searchHelper(String word, int index, Node root) {
        Node current = root;

        // if(word.length() == 1 && word.charAt(0) == '.'){
        //     return current.children.values().stream().anyMatch(value -> value.isEnding);
        // }
        for(int i=index;i<word.length();i++){
            char c = word.charAt(i);

            if(c == '.'){
                for(Node child: current.children.values()){
                    if(searchHelper(word, i+1 , child)){
                        return true;
                    }
                }
                return false;
            }

            
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEnding;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, this.root);
    }
}
