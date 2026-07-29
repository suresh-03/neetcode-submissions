class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0){
                    q.offer(new Pair(row,col));
                    visited[row][col] = true;
                }
            }
        }

        int distance = 0;

        while(!q.isEmpty()){
            int queueSize = q.size();
            for(int i = 0; i < queueSize; i++){
                Pair p = q.poll();
                int r = p.row;
                int c = p.col;

                grid[r][c] = distance;

                int[][] dist = {
                    {0,-1},
                    {0,1},
                    {1,0},
                    {-1,0}
                };

                for(int d = 0; d < dist.length; d++){
                    int dr = r + dist[d][0];
                    int dc = c + dist[d][1];

                    if(dr < 0 || dc < 0 || dr >= m || dc >= n || visited[dr][dc] || grid[dr][dc] == -1){
                        continue;
                    }

                    q.offer(new Pair(dr,dc));
                    visited[dr][dc] = true;
                }

              
            }
            distance++;
        }


    }
}

class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
