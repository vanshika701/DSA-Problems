class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] live=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int c=0;
                if(j!=n-1){
                    if(board[i][j+1]==1)
                    c++;
                    if(i!=m-1)
                    {if(board[i+1][j+1]==1)
                    c++;}
                    if(i!=0)
                    {
                        if(board[i-1][j+1]==1)
                        c++;
                    }
                }
                if(i!=m-1){
                    if(board[i+1][j]==1)
                    c++;

                }
                if(j!=0){
                    if(board[i][j-1]==1)
                    c++;
                    if(i!=0){
                         if(board[i-1][j-1]==1)
                        c++;
                    }
                    if(i!=m-1){
                        if(board[i+1][j-1]==1)
                        c++;
                    }
                }
                if(i!=0){
                    if(board[i-1][j]==1)
                    c++;
                }
                if(c<2)
                live[i][j]=false;
                else
                if((c==2||c==3)&&board[i][j]==1)
                live[i][j]=true;
                else
                if(c==3&&board[i][j]==0)
                live[i][j]=true;
                else
                if(board[i][j]==1&&c>3)
                live[i][j]=false;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(live[i][j]==true)
                board[i][j]=1;
                else
                board[i][j]=0;
            }
        }
    }
}