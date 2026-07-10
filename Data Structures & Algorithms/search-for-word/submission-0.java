class State {
    int row;
    int col;
    int index;
    boolean[][] vis;

    State(int row, int col, int index, boolean[][] vis) {
        this.row = row;
        this.col = col;
        this.index = index;
        this.vis = vis;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        Queue<State> q = new LinkedList<>();

        // Start BFS from every cell matching first character
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {

                    boolean[][] vis = new boolean[n][m];
                    vis[i][j] = true;

                    q.offer(new State(i, j, 0, vis));
                }
            }
        }

        while (!q.isEmpty()) {

            State curr = q.poll();

            if (curr.index == word.length() - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = curr.row + delRow[k];
                int nc = curr.col + delCol[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !curr.vis[nr][nc] &&
                    board[nr][nc] == word.charAt(curr.index + 1)) {

                    // Copy visited matrix
                    boolean[][] newVis = new boolean[n][m];

                    for (int x = 0; x < n; x++) {
                        newVis[x] = curr.vis[x].clone();
                    }

                    newVis[nr][nc] = true;

                    q.offer(new State(nr, nc, curr.index + 1, newVis));
                }
            }
        }

        return false;
    }
}
    }
}
