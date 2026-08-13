class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        int ans = fib(n,memo);
        System.out.println(Arrays.toString(memo));
        return ans;
    }

    public int fib(int n,int[] memo){
        if(n <= 1){
            return 1;
        }

        if(memo[n] != 0){
            return memo[n];
        }

        return memo[n] = fib(n-1,memo) + fib(n-2,memo);
    }
}
