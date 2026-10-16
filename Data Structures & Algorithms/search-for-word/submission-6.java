class Solution {

    public boolean dfs(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visited){
        if(i>=board.length 
            || j>=board[0].length 
            || wordIndex>=word.length() 
            || i<0 
            || j<0
            || visited[i][j] == true
        ){
            return false;
        }


        if(board[i][j] == word.charAt(wordIndex)){
            visited[i][j] = true;
            boolean found = (wordIndex == word.length() - 1)
                || dfs(board, i+1, j, word, wordIndex+1, visited) 
                || dfs(board, i, j+1, word, wordIndex+1, visited)
                || dfs(board, i-1, j, word, wordIndex+1, visited) 
                || dfs(board, i, j-1, word, wordIndex+1, visited);

            visited[i][j] = false;  // backtrack

            return found;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == word.charAt(0)){
                   boolean[][] visited = new boolean[rows][cols];
                    if(dfs(board, i, j, word, 0, visited)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
