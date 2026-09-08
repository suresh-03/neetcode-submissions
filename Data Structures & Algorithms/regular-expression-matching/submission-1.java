class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return isMatch(0, 0, s, p, dp);
    }

    public boolean isMatch(int i, int j, String s, String p, int[][] dp) {
        if (j == p.length()) {
            return i == s.length();
        }

         if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

       

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean res =
                isMatch(i, j + 2, s, p, dp) || (firstMatch && isMatch(i + 1, j, s, p, dp));
            dp[i][j] = res ? 1 : 0;
            return res;
        }

        boolean res = firstMatch && isMatch(i + 1, j + 1, s, p, dp);
        dp[i][j] = res ? 1 : 0;
        return res;
    }
}
