import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static class Node {
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		for (int i = 0; i < M; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// System.out.println(Arrays.deepToString(arr));
		visited = new boolean[M][N];

		int powerW = 0;
		int powerB = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				int cnt = bfs(i,j);
				if (arr[i][j] == 'W') {
					powerW += Math.pow(cnt, 2);
				} else {
					powerB += Math.pow(cnt, 2);
				}
			}
		}
		System.out.println(powerW + " " + powerB);
	}
	public static int bfs(int i, int j) {
		char color = arr[i][j];
		ArrayDeque<Node> q = new ArrayDeque<>();
		visited[i][j] = true;
		int result = 1;
		q.add(new Node(i,j));

		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = dy[k] + now.r;
				int nx = dx[k] + now.c;
				if (ny < 0 || nx < 0 || ny >= M || nx >= N)
					continue;
				if (visited[ny][nx] || arr[ny][nx] != color)
					continue;
				visited[ny][nx] = true;
				result++;
				q.add(new Node(ny, nx));
			}
		}
		return result;
	}
}
