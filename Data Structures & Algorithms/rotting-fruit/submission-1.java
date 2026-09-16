class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] toGo = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };
        int counter = 0;
        List<int[]> cur = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    cur.add(new int[]{i,j});
                }
            }
        }
        while(!cur.isEmpty()){
            List<int[]> nextLvl = new ArrayList<>();
            for(int[] lvl : cur){
                for(int[] tg : toGo){
                    int r = lvl[0] + tg[0];
                    int c = lvl[1] + tg[1];
                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                        nextLvl.add(new int[]{r,c});
                        grid[r][c] = 2;
                    }
                }                
            }
            cur = nextLvl;
            if(!cur.isEmpty()) counter++;            
        }
         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return counter;
    }
}
