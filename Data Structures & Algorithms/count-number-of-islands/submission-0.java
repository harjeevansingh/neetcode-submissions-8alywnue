class Solution {

    public void dfs(char[][] grid, HashSet<Integer[]> visited, int r, int c){
        if( r>= 0 && r<grid.length
            && c>= 0 && c<grid[0].length
            && grid[r][c] == '1' 
            && !visited.contains(new Integer[]{r, c})
           ){
                grid[r][c] = '0';
                
                visited.add(new Integer[]{r, c});

                dfs(grid, visited, r+1,c);
                dfs(grid, visited, r-1,c);
                dfs(grid, visited, r,c+1);
                dfs(grid, visited, r,c-1);
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        HashSet<Integer[]> visited = new HashSet<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == '1' && !visited.contains(new Integer[]{r, c})){
                    dfs(grid, visited, r, c);
                    islands++;
                }
            }
        }

        return islands;
        
    }
}
