class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return minDistance(0, 0, word1, word2, dp);
    }

    public int minDistance(int i, int j, String word1, String word2,int[][] dp) {
        if (j == word2.length()) {
            if (i <= word1.length()) {
                return word1.length() - i;
            } else {
                return 0;
            }
        }

        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistance(i + 1, j + 1, word1, word2, dp);
        }

        int delete = 1 + minDistance(i + 1, j, word1, word2, dp);
        int insert = 1 + minDistance(i, j + 1, word1, word2, dp);
        int replace = 1 + minDistance(i + 1, j + 1, word1, word2, dp);

        return dp[i][j] = Math.min(delete, Math.min(insert, replace));
    }
}
