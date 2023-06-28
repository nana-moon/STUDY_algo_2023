import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] origin = new int[N][M];
		dp = new int[N+1][M+1];
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				// 누적합 배열 만들기
				dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + origin[i][j];
			}
		}
		// System.out.println(Arrays.deepToString(dp));

		int T = Integer.parseInt(br.readLine());
		// System.out.println(T);
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(range_sum(x1, y1, x2, y2) + "\n");
		}
		System.out.println(sb);
	}

	private static int range_sum(int x1, int y1, int x2, int y2) {
		return dp[x2][y2] - (dp[x1-1][y2] +dp[x2][y1-1]) + dp[x1-1][y1-1];
	}
}
