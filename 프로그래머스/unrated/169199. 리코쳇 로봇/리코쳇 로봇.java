import java.io.*;
import java.util.*;

class Solution {
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
    
    static int N, M;
    static boolean[][] visited;
    
    static String[] arr;
    
    static class Node {
        int y, x, depth;
        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }

	public static int solution(String[] board) {
        arr = board;
		N = board.length;
		M = board[0].length();
        Node start = null;
        Node end = null;
        for (int i = 0; i < N; i++) {
            for (int j =0; j < M; j++) {
                char tmp = board[i].charAt(j);
                
                if (tmp == 'R') {
                    start = new Node(i,j,0);
                } else if (tmp == 'G') {
                    end = new Node(i,j,0);
                }
            }
        }
        return bfs(start, end);
		
	}
    
	public static int bfs(Node st, Node ed) {
        visited = new boolean[N][M];
		visited[st.y][st.x] = true;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(st);
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.y == ed.y && now.x == ed.x) return now.depth; 
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y;
                int nx = now.x;
                // 범위에 포함, 장애물 X
                while (isRange(ny,nx) && arr[ny].charAt(nx) != 'D') {
                    ny += dy[i];
                    nx += dx[i];
                }
                // 갈 수 있는 곳으로 back
                ny -= dy[i];
                nx -= dx[i];
                
                // 방문한 곳이거나 출발 지점과 같은 곳이면 skip
                if (visited[ny][nx] || (ny == now.y && nx == now.x)) continue;
                
                visited[ny][nx] = true;
                q.offer(new Node(ny,nx,now.depth+1));
            }
        }
        return -1;
	}
    
    public static boolean isRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}