import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r,c,dist;
		boolean[][] visited;
		public Node(int r, int c, int dist, boolean[][] visited) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.visited = visited;
		}
	}
	static int R, C, K;
	static char[][] arr;
	static int[][] dict = {{0,1},{0,-1},{1,0},{-1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		System.out.println(bfs(R-1,0));
	}
	public static int bfs(int a, int b) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		boolean[][] temp = new boolean[R][C];
		temp[a][b] = true;
		q.offer(new Node(a,b,1, temp));
		int result = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.r == 0 && now.c == C-1 && now.dist == K) {
				result += 1;
			}
			for (int i = 0; i < 4; i++) {
				int ny = dict[i][0] + now.r;
				int nx = dict[i][1] + now.c;
				if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
				if (now.visited[ny][nx] || arr[ny][nx] == 'T') continue;
				// now.visited[ny][nx] = true;
				// 클론 > 깊은 복사 아님(2차원 배열에서), System.arraycopy 사용
				boolean[][] copied = new boolean[R][C];
				for (int n = 0; n < R; n++) {
					System.arraycopy(now.visited[n], 0, copied[n], 0, copied[n].length);
				}
				copied[ny][nx] = true;
				q.offer(new Node(ny, nx, now.dist+1, copied));
			}
		}
		return result;
	}
}
