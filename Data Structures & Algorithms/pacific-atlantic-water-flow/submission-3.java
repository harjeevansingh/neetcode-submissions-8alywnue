class Solution {

    public void dfs(int r, int c, boolean[][] visit, int[][] heights, int currentHeight){
        if(
            r < 0
            || c < 0
            || r >= heights.length
            || c >= heights[0].length
            || visit[r][c]
            || currentHeight > heights[r][c]
        ){
            return;
        }

        visit[r][c] = true;

        dfs(r+1, c, visit, heights, heights[r][c]);
        dfs(r-1, c, visit, heights, heights[r][c]);
        dfs(r, c+1, visit, heights, heights[r][c]);
        dfs(r, c-1, visit, heights, heights[r][c]);
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            dfs(r, 0, pac, heights, heights[r][0]);
            dfs(r, cols-1, atl, heights, heights[r][cols-1]);
        }

        for(int c=0;c<cols;c++){
            dfs(0, c, pac, heights, heights[0][c]);
            dfs(rows-1, c, atl, heights, heights[rows-1][c]);
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pac[r][c] && atl[r][c]){
                    ans.add(Arrays.asList(r, c));
                }
            }
        }
        return ans;
    }




    // Less optimised solution

    // boolean pacific = false;
    // boolean atlantic = false;

    // public void dfs(int[][] heights, int i, int j, int currentHeight){
    //     int rows = heights.length;
    //     int cols = heights[0].length;

    //     if(i<0|| j<0){
    //         pacific = true;
    //         return;
    //     }

    //     if(i>=rows || j>=cols){
    //         atlantic = true;
    //         return;
    //     }

    //     if(heights[i][j] > currentHeight){
    //         return;
    //     }

    //     int temp = heights[i][j];
    //     heights[i][j] = Integer.MAX_VALUE;
    //     dfs(heights, i+1, j, temp);
    //     dfs(heights, i-1, j, temp);
    //     dfs(heights, i, j+1, temp);
    //     dfs(heights, i, j-1, temp);
    //     heights[i][j] = temp;
    // }

    // public List<List<Integer>> pacificAtlantic(int[][] heights) {
    //     int rows = heights.length;
    //     int cols = heights[0].length;

    //     List<List<Integer>> ans = new LinkedList<>();

    //     for(int i=0;i<rows;i++){
    //         for(int j=0;j<cols;j++){
    //             int currentHeight = heights[i][j];
    //             pacific = false;
    //             atlantic = false;
    //             dfs(heights, i, j, Integer.MAX_VALUE);
    //             if(pacific && atlantic){
    //                 ans.add(Arrays.asList(i, j));
    //             }
    //         }
    //     }
    //     return ans;
    // }
}
