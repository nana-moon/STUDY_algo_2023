import java.io.*;
import java.util.*;
class Solution {
    static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int[][][] visited;
	static class Node{
		int y,x,cost, dir;
		public Node (int y, int x, int cost, int dir) {
			this.y = y;
			this.x = x;
			this.cost = cost;
			this.dir = dir;
		}
	}

	public static int solution(int[][] board) {
		int N = board.length;
		ArrayDeque<Node> q = new ArrayDeque<>();
		visited = new int[N][N][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 && j == 0) {
					Arrays.fill(visited[i][j], 0);
				} else {
					Arrays.fill(visited[i][j], Integer.MAX_VALUE);
				}
			}
		}
		q.offer(new Node(0,0,0,-1));
		int result = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node now = q.poll();
			// System.out.println(now.y + " " + now.x + " " + now.cost);
			// System.out.println(Arrays.deepToString(now.visited));

			if (now.y == N-1 && now.x == N-1) {
				result = Math.min(now.cost, result);

			}
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + now.y;
				int nx = dx[i] + now.x;
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

				if (board[ny][nx] == 1) continue;
				int nCost = now.cost + 100;
				if (now.dir != -1 && now.dir != i) nCost += 500;
				// 등호를 제거해야 함
				if (visited[ny][nx][i] <= nCost) continue;
				visited[ny][nx][i] = nCost;
				q.offer(new Node(ny,nx,nCost,i));
			}
		}
		return result;
	}
    
}