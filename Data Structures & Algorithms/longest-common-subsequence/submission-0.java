class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(text1.length() - 1, text2.length() - 1, text1, text2, dp);
    }

    public int solve(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + solve(ind1 - 1, ind2 - 1, s1, s2, dp);
        }

        return dp[ind1][ind2] =
                   Math.max(solve(ind1 - 1, ind2, s1, s2, dp), solve(ind1, ind2 - 1, s1, s2, dp));
    }
}
