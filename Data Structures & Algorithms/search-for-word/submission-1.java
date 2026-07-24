class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (exist(r, c, board, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(
        int r, int c, char[][] board, String word, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length) {
            return false;
        }

        if (word.charAt(index) != board[r][c] || visited[r][c]) {
            return false;
        }

        if (word.charAt(index) == board[r][c]) {
            visited[r][c] = true;

            if (exist(r + 1, c, board, word, visited, index + 1)) {
                return true;
            }
            if (exist(r - 1, c, board, word, visited, index + 1)) {
                return true;
            }
            if (exist(r, c + 1, board, word, visited, index + 1)) {
                return true;
            }
            if (exist(r, c - 1, board, word, visited, index + 1)) {
                return true;
            }

            visited[r][c] = false;
        }
        return false;
    }
}
