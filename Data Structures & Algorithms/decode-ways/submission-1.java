class Solution {
    // public int count = 0;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }

        return solve(0,s,dp);
        // return count;

    }

    public int solve(int index,String s,int[] dp){
        if(index >= s.length()){
            return 1;
        }

        if(s.charAt(index) == '0'){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int res = solve(index+1,s,dp);

        if((index+1) < s.length() && (s.charAt(index) == '1' || s.charAt(index) == '2' && "0123456".indexOf(s.charAt(index+1)) != -1)){
            res += solve(index+2,s,dp);
        }

        return dp[index] = res;

        // for(int i = index; i < s.length(); i++){
        //     int start = index;
        //     int end = i + 1;


        //     if(set.contains(s.substring(start,end))){
        //         dp[i] = solve(i+1,s,set);
        //     }
        //     else{
        //         return 0;
        //     }

        // }
        // return dp[index];
    }
}
