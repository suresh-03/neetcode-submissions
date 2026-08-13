class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[][] memo = new int[cost.length][2];
        for(int i = 0; i < cost.length; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return Math.min(climb(0, cost, memo, 0), climb(1, cost, memo, 0));
    }

    public int climb(int index, int[] cost, int[][] memo, int step) {
        if (index >= cost.length) {
            return 0;
        }

        if (memo[index][step] != -1) {
            return memo[index][step];
        }

        return memo[index][step] = cost[index]
            + Math.min(climb(index + 1, cost, memo, 0), climb(index + 2, cost, memo, 1));
    }
}
