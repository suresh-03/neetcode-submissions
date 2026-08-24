class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0,m-1,n-1,dp);
    }

    public int solve(int r, int c, int m, int n,int[][] dp){
        if(r == m && c == n){
            return 1;
        }
        if(r > m || c > n){
            return 0;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        return dp[r][c] = solve(r+1,c,m,n,dp) + solve(r,c+1,m,n,dp);
    }
}
