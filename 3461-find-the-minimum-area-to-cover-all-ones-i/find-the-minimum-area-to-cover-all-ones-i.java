class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minrow = n , maxrow = -1;
        int mincol = m , maxcol = -1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    minrow = Math.min(minrow , i);
                    maxrow = Math.max(maxrow , i);
                    mincol = Math.min(mincol , j);
                    maxcol = Math.max(maxcol , j);
                }
            }
        }
        return (maxrow-minrow +1)*(maxcol-mincol +1);
    }
}