class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }
            if (board[n - 1][c] == 'O') {
                dfs(n - 1, c, board);
            }
        }

        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }
            if (board[r][m - 1] == 'O') {
                dfs(r, m - 1, board);
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(board[r][c] == 'N'){
                    board[r][c] = 'O';
                }
                else{
                    board[r][c] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board){
        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] == 'X' || board[row][col] == 'N'){
            return;
        }

        board[row][col] = 'N';

        dfs(row+1,col,board);
        dfs(row-1,col,board);
        dfs(row,col+1,board);
        dfs(row,col-1,board);

    }
}
