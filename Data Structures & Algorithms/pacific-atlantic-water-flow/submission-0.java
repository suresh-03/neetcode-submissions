class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights)  {   
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pacificVisit = new boolean[n][m];
        boolean[][] atlanticVisit = new boolean[n][m];

        for(int c = 0; c < m; c++){
            dfs(0,c,pacificVisit,heights,heights[0][c]);
            dfs(n-1,c,atlanticVisit,heights,heights[n-1][c]);
        }

        for(int r = 0; r < n; r++){
            dfs(r,0,pacificVisit,heights,heights[r][0]);
            dfs(r,m-1,atlanticVisit,heights,heights[r][m-1]);
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(pacificVisit[r][c] && atlanticVisit[r][c]){
                    List<Integer> list = new ArrayList<>();
                    list.add(r);
                    list.add(c);
                    ans.add(list);
                }
            }
        }

        return ans;

    }

    public void dfs(int row, int col, boolean[][] visited, int[][] heights, int previousHeight){
        if(row < 0 || col < 0 || row >= heights.length || col >= heights[row].length || visited[row][col] || heights[row][col] < previousHeight){
            return;
        }

        visited[row][col] = true;

        dfs(row+1,col,visited,heights,heights[row][col]);
        dfs(row-1,col,visited,heights,heights[row][col]);
        dfs(row,col+1,visited,heights,heights[row][col]);
        dfs(row,col-1,visited,heights,heights[row][col]);

    }
}
