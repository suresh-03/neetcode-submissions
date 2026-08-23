class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        return solve(0, s, wordDict,dp);
    }

    public boolean solve(int index, String s, List<String> wordDict,int[] dp) {
        if (index >= s.length()) {
            return true;
        }

        if(dp[index] != -1){
            return dp[index] == 0 ? false : true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (index + wordDict.get(i).length() <= s.length()) {
                if (s.substring(index, index + wordDict.get(i).length()).equals(wordDict.get(i))) {
                    if (solve(index + wordDict.get(i).length(), s, wordDict,dp)) {
                        dp[index] = 1;
                        return true;
                    }
                }
            }
        }
        dp[index] = 0;
        return false;
    }
}
