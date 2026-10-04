class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        int k=0;
        int p=matrix.length-1;
        while(k<p){
            for(int j=0;j<matrix[0].length;j++){
                int temp=matrix[j][k];
                matrix[j][k]=matrix[j][p];
                matrix[j][p]=temp;
            }
            k++;
            p--;
        }
    }
}