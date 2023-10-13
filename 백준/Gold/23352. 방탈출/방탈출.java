import java.util.*;
import java.io.*;
public class Main {
	static int N, M, arr[][], maxLen, maxSum;
	static boolean visited[][];
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static class Node {
		int y, x, move;
		public Node(int y, int x, int move) {
			this.y = y;
			this.x = x;
			this.move = move;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		maxLen = 0;
		maxSum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) continue;
				visited = new boolean[N][M];
				visited[i][j] = true;
				bfs(i, j, 0);
			}
		}
		System.out.println(maxSum);
	}
	public static void bfs(int i, int j, int cnt) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(new Node(i,j,cnt));
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.move > maxLen) {
				maxLen = now.move;
				maxSum = arr[i][j] + arr[now.y][now.x];
			} else if (now.move == maxLen) {
				maxSum = Math.max(maxSum, arr[i][j] + arr[now.y][now.x]);
			}

			for (int k =0; k < 4; k++) {
				int ny = dy[k] + now.y;
				int nx = dx[k] + now.x;
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (arr[ny][nx] == 0 || visited[ny][nx]) continue;
				visited[ny][nx] = true;
				q.offer(new Node(ny,nx,now.move+1));
			}
		}
	}
}
