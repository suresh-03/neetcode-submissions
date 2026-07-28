class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                   maxArea = Math.max(dfs(grid, i, j),maxArea);
                }
            }
        }

        return maxArea;
    }
    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
            || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1)
            + dfs(grid, row, col - 1);
    }
}
