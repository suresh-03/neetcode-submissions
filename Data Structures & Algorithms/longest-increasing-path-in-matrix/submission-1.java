class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, longestIncreasingPath(i, j, matrix, -1,dp));
            }
        }

        return ans;
    }

    public int longestIncreasingPath(int row, int col, int[][] matrix, int prev,int[][] dp) {
        if (row < 0 || col < 0 || row == matrix.length || col == matrix[row].length
            || matrix[row][col] <= prev) {
            return 0;
        }

        if(dp[row][col] != 0){
            return dp[row][col];
        }

        int ans = 1;
        ans = Math.max(ans, 1 + longestIncreasingPath(row + 1, col, matrix, matrix[row][col],dp));
        ans = Math.max(ans, 1 + longestIncreasingPath(row - 1, col, matrix, matrix[row][col],dp));
        ans = Math.max(ans, 1 + longestIncreasingPath(row, col + 1, matrix, matrix[row][col],dp));
        ans = Math.max(ans, 1 + longestIncreasingPath(row, col - 1, matrix, matrix[row][col],dp));

        return dp[row][col] = ans;
    }
}
