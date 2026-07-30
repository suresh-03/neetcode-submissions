class Solution {
    public int orangesRotting(int[][] grid) {
        int minimumMinutes = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 2){
                    q.offer(new Cell(r,c));
                    visited[r][c] = true;
                }
            }
        }

        int[][] directions = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Cell c = q.poll();
                int row = c.row;
                int col = c.col;

                for(int d = 0; d < directions.length; d++){
                    int dr = row + directions[d][0];
                    int dc = col + directions[d][1];

                    if(dr < 0 || dc < 0 || dr >= m || dc >= n || visited[dr][dc] || grid[dr][dc] == 0){
                        continue;
                    }

                    grid[dr][dc] = 2;
                    q.offer(new Cell(dr,dc));
                    visited[dr][dc] = true;
                }
            }

            if(!q.isEmpty()){
            minimumMinutes++;
            }
            
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1){
                    return -1;
                }
            }
        }

        return minimumMinutes;
    }
}

class Cell{
    int row;
    int col;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
