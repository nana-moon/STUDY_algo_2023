import java.util.*;
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] dir = {"d", "l", "r", "u"};
    
    class Node {
        int r, c;
        StringBuilder path;
        public Node(int r, int c, StringBuilder path) {
            this.r = r;
            this.c = c;
            this.path = path;
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(x-1, y-1, new StringBuilder()));
        boolean[][][] visited = new boolean[n][m][k+1];
        visited[x-1][y-1][0] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.r == r-1 && now.c == c-1) {
                if (now.path.toString().length() == k) {
                    return now.path.toString();
                }
            }
            if (now.path.toString().length() == k) continue;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.r;
                int ny = dy[i] + now.c;
                if (nx < 0 || ny < 0|| nx >= n || ny >= m) continue;
                if (visited[nx][ny][now.path.toString().length()+1]) continue;
                visited[nx][ny][now.path.toString().length()+1] = true;
                q.offer(new Node(nx,ny, new StringBuilder(now.path).append(dir[i])));
            }
        } 
        return "impossible";
    }
}