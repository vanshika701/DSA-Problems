class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[] nextrow = {-1, 0, +1, 0};
        int[] nextcol = {0, +1, 0, -1};

        // Left and right boundaries
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                q.add(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][n - 1] == 'O') {
                q.add(new int[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }

        // Top and bottom boundaries
        for (int i = 0; i < n; i++) {

            if (board[0][i] == 'O') {
                q.add(new int[]{0, i});
                board[0][i] = '#';
            }

            if (board[m - 1][i] == 'O') {
                q.add(new int[]{m - 1, i});
                board[m - 1][i] = '#';
            }
        }

        // BFS
        while (!q.isEmpty()) {

            int r = q.peek()[0];
            int c = q.peek()[1];

            q.poll();

            for (int i = 0; i < 4; i++) {

                int nr = r + nextrow[i];
                int nc = c + nextcol[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    board[nr][nc] == 'O') {

                    q.add(new int[]{nr, nc});
                    board[nr][nc] = '#';
                }
            }
        }

        // Capture surrounded regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}