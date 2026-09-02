class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return numDistinct(0, 0, s, t, dp);
    }

    public int numDistinct(int si, int ti, String s, String t, int[][] dp) {
        if (ti == t.length()) {
            return 1;
        }
        if (si == s.length()) {
            return 0;
        }

        if(dp[si][ti] != -1){
            return dp[si][ti];
        }

        if (s.charAt(si) == t.charAt(ti)) {
            return dp[si][ti] = numDistinct(si + 1, ti + 1, s, t, dp) + numDistinct(si + 1, ti, s, t, dp);
        }
        return dp[si][ti] = numDistinct(si + 1, ti, s, t, dp);
    }
}
