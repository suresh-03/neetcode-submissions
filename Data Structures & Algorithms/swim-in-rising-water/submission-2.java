class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.elevation - b.elevation);

        pq.add(new Cell(grid[0][0],0,0));

        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

        while(!pq.isEmpty()){
            Cell c = pq.poll();
            int elevation = c.elevation;
            int row = c.row;
            int col = c.col;

            visited[row][col] = true;

            if(row == grid.length - 1 && col == grid.length - 1){
                return elevation;
            }

            for(int d = 0; d < 4; d++){
                int dr = directions[d][0] + row;
                int dc = directions[d][1] + col;

                if(dr < 0 || dc < 0 || dr >= grid.length || dc >= grid[dr].length || visited[dr][dc]){
                    continue;
                }
                // visited[dr][dc] = true;
                int nextElevation = Math.max(elevation,grid[dr][dc]);
                pq.add(new Cell(nextElevation,dr,dc));

            }
        }
        return -1;
    }

    private class Cell{
        int elevation;
        int row;
        int col;

        public Cell(int elevation, int row, int col){
            this.elevation = elevation;
            this.row = row;
            this.col = col;
        }
    }
}
