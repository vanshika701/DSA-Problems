class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        Queue<int []> que=new LinkedList<>();
        int fresh=0;//to keep a count fo how many fresh orange are there
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                {
                    que.add(new int[]{i,j,0});
                    vis[i][j]=2;
                }
                else
                {vis[i][j]=0;
                }
                if(grid[i][j]==1)
                fresh++;
            }
        }
        int[] nextRow={-1,0,+1,0};
            int[] nextCol={0,+1,0,-1};
            int tm=0;
            int cnt=0;
        while(!que.isEmpty()){
            int r=que.peek()[0];
            int c=que.peek()[1];
            int t=que.peek()[2];
            que.poll();
            tm=Math.max(tm,t);
            for(int i=0;i<4;i++){
                int nr=r+nextRow[i];
                int nc=c+nextCol[i];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&vis[nr][nc]==0&&grid[nr][nc]==1)
                {que.add(new int[]{nr,nc,t+1});
                vis[nr][nc]=2;
                cnt++;
                }
            }
        }
        if(cnt!=fresh)
        return -1;
        return tm;
    }
}