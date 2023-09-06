import java.io.*;
import java.util.*;

public class Main {
	static int N,M, arr[][], maxSum;
	static boolean[][] visited;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxSum = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				initPq();
				visited[i][j] = true;
				dfs(i,j, 1, arr[i][j]);
				// 꼭 false 처리 해야 함..
				visited[i][j] = false;
				if (pq.size() >= 3) {
					maxSum = Math.max(maxSum, arr[i][j] + pq.poll() + pq.poll() + pq.poll());
				}
			}
		}
		System.out.println(maxSum);
	}
	public static void dfs(int y, int x, int cnt, int sum) {

		if (cnt == 4) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if (visited[ny][nx]) continue;
			visited[ny][nx] = true;
			dfs(ny, nx, cnt+1, sum+arr[ny][nx]);
			visited[ny][nx] = false;
			// 볼록할 철 만들기
			if (cnt == 1) {
				pq.add(arr[ny][nx]);
			}
		}
	}
	public static void initPq() {
		pq = new PriorityQueue<>((a,b) -> b-a);
	}
}
