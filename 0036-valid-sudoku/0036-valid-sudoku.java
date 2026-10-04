class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] cols=new boolean[9][9];
        boolean[][] box=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int boxNum = (i / 3) * 3 + (j / 3);;
                if(board[i][j]!='.'){
                int num=board[i][j]-'1';
                if(row[i][num]==true||
                    cols[j][num]==true||
                        box[boxNum][num]==true )
                            {
                                return false;
                            }
                row[i][num]=true;
                cols[j][num]=true;
                box[boxNum][num]=true;
                }
            }
        }
        return true;
    }
}