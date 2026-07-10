class Pair{
    int first;int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    private void bfs(int row,int col,boolean[][] vis,char[][] board){
        int n=board.length;
        int m=board[0].length;
        vis[row][col]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            int delrow[]={-1,0,1,0};
            int delcol[]={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && board[nrow][ncol]=='O'){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        // First row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                bfs(0, j, vis, board);
            }
        }
        // Last row
        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                bfs(n - 1, j, vis, board);
            }
        }
        // First column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                bfs(i, 0, vis, board);
            }
        }
        // Last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                bfs(i, m - 1, vis, board);
            }
        }
        // Convert surrounded O to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }

            }
        }
    }
}