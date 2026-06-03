class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        for(char[] row: board){
            HashSet<Character> xAxisHash = new HashSet<Character>();
            for(char element: row){
                if(element != '.' && xAxisHash.contains(element)){
                    System.out.println("xAxisHash contains " + element + "for " + row);
                    return false;
                } else{
                    xAxisHash.add(element);
                }
            }   
        }


        for(int i=0;i<9;i++){
            HashSet<Character> yAxisHash = new HashSet<Character>();
            for(char[] row: board){
                if(row[i] != '.' && yAxisHash.contains(row[i])){
                    System.out.println("yAxisHash contains " + row[i] + "for i = " + i + " and row - " + row);
                    return false;
                } else{
                    yAxisHash.add(row[i]);
                }
            }
        }

        // Map<Pair<Character, Character>, HashSet<Character>> boxSet = new HashMap<>();
        // for (int j = 0, k = 0; j < 9 && k < 9; j++, k++) {
        //     if(boxSet.get(new Pair()))
        // }

        HashSet[][] boxWiseGrid = new HashSet[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxWiseGrid[i][j] = new HashSet<>();
            }
        }
        
        for(int i=0;i<9; i++){
            for(int j=0;j<9; j++){
                System.out.println("boxWiseGrid x & y " + board[i][j] + "for i = " + i/3 + " and j - " + j/3);
                if(board[i][j] == '.'){
                    continue;
                }
                if(boxWiseGrid[i/3][j/3].contains(board[i][j])){
                    System.out.println("boxWiseGrid contains " + board[i][j] + "for i = " + i + " and j - " + j);
                    return false;
                } else {
                    boxWiseGrid[i/3][j/3].add(board[i][j]);
                }
            }
        }

        return true;

    }
}
