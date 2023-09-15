import java.io.*;
import java.util.*;
public class Main {
	// DP + dfs
	static int M, N, arr[][];
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int[][] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		// System.out.println(Arrays.deepToString(dp));
		System.out.println(dfs(0,0));

	}
	public static int dfs(int y, int x) {
		if(y == M-1 && x == N-1) {
			return 1;
		}
		if (dp[y][x] != -1) {
			return dp[y][x];
		}
		dp[y][x] = 0;
		for(int i  = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;
			if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
			if (arr[ny][nx] >= arr[y][x]) continue;

			dp[y][x] += dfs(ny,nx);
		}
		return dp[y][x];
	}
}
