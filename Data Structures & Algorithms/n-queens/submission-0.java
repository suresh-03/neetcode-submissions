class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();

        solve(n,board,ans,0);
        return ans;
    }

    public void solve(int n, boolean[][] board, List<List<String>> ans, int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j]){
                        str.append('Q');
                    }
                    else{
                        str.append('.');
                    }
                }
                list.add(str.toString());
            }
            ans.add(list);
            return;
        }

        for(int col = 0; col < n; col++){
            if(canPlaceQ(row,col,board)){
                board[row][col] = true;
                solve(n,board,ans,row+1);
                board[row][col] = false;
            }
        }
    }

    public boolean canPlaceQ(int row, int col, boolean[][] board){
        for(int i = 0; i < board.length; i++){
            if(board[row][i]){
                return false;
            }
            if(board[i][col]){
                return false;
            }
        }

        int diagonalRow = row;
        int diagonalCol = col;

        while(diagonalRow >= 0 && diagonalCol >= 0){
            if(board[diagonalRow--][diagonalCol--]){
                return false;
            }
        }

        diagonalRow = row;
        diagonalCol = col;

        while(diagonalRow >= 0 && diagonalCol < board[diagonalRow].length){
            if(board[diagonalRow--][diagonalCol++]){
                return false;
            }
        }

        return true;
    }
}
