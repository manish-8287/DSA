class Solution {
    void dfs(char[][] grid , int i ,int j,int m,int n)
    {
        if(grid[i][j]=='0' || i>m || i<0 || j>n || j<0) return;
        grid[i][j]='0';
        if(i+1<m)
        {
            dfs(grid,i+1,j,m,n);
        }
        if(i-1>=0)
        {
            dfs(grid,i-1,j,m,n);
        }
        if(j+1<n)
        {
            dfs(grid,i,j+1,m,n);
        }
        if(j-1>=0)
        {
            dfs(grid,i,j-1,m,n);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j,m,n);
                    c++;
                }
            }
        }
        return c;
    }
}