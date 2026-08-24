class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // int ans = solve(0,0,m-1,n-1,dp);
        // for(int[] arr : dp){
        //     System.out.println(Arrays.toString(arr));
        // }
        // return ans;
        dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i+1 <= m-1){
                    dp[i][j] += dp[i+1][j];
                }
                if(j+1 <= n-1){
                    dp[i][j] += dp[i][j+1];
                }
            }
        }

        return dp[0][0];
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
