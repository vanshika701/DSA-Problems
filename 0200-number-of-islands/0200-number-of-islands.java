class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[] nextrow={-1,0,+1,0};
        int[] nextcol={0,+1,0,-1};
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        int r=q.peek()[0];
                        int c=q.peek()[1];
                        q.poll();
                        for(int k=0;k<4;k++){
                            int nr=r+nextrow[k];
                            int nc=c+nextcol[k];
                            if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]=='1')
                            {
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}