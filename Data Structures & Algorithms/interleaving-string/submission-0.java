class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return isInterleave(0, 0, s1, s2, s3, dp);
    }

    public boolean isInterleave(
        int i, int j, String s1, String s2, String s3, int[][] dp) {
        if (i+j == s3.length()) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }

        int k = i+j;

        boolean match1 = false;
        boolean match2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            match1 = isInterleave(i + 1, j, s1, s2, s3, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            match2 = isInterleave(i, j + 1, s1, s2, s3, dp);
        }

        boolean ans = match1 || match2;
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
