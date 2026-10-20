class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isEnding;
    String word;

    public TrieNode(){
        children = new HashMap<>();
    }
}
class Solution {
    TrieNode root;

    public Solution(){
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode current = this.root;

        for(char c: word.toCharArray()){
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }

        // current.isEnding = true;
        current.word = word;
    }

    public void dfs(char[][] board, int i, int j, boolean[][] visited, TrieNode node, List<String> ans){
        TrieNode current = node;

        int rows = board.length;
        int cols = board[0].length;

        if(
            i>=rows
            || j>=cols
            || i<0
            || j<0
            || visited[i][j] == true
 
        ){
            return;
        }

        current = node.children.get(board[i][j]);
        if(current == null){
            return;
        }

        visited[i][j] = true;

        // word += board[i][j];
        // if(current.isEnding){
        //     ans.add(word);
        // }
        if (current.word != null) {
            ans.add(current.word);
            current.word = null;
        }

        dfs(board, i+1, j, visited, current, ans);
        dfs(board, i-1, j, visited, current, ans);
        dfs(board, i, j+1, visited, current, ans);
        dfs(board, i, j-1, visited, current, ans);

        visited[i][j] = false;

    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words){
            addWord(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<String> ans = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(this.root.children.containsKey(board[i][j])){
                    dfs(board, i, j, visited, this.root, ans);
                }
            }
        }
        return ans;
        
    }
}
