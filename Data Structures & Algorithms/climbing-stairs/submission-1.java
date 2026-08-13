class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return fib(n,memo);
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
