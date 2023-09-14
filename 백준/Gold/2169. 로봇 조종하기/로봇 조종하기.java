import java.io.*;
import java.util.*;
public class Main {
	static int[][] dp, arr;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][M];
		dp[0][0] = arr[0][0];
		for (int i = 1; i < M; i++) {
			dp[0][i] = arr[0][i] + dp[0][i-1];
		}
		int[][] tmp = new int[2][M];

		for(int i = 1; i < N; i++) {
			// 왼 -> 오
			tmp[0][0] = arr[i][0] + dp[i-1][0];
			for (int j = 1; j < M; j++) {
				tmp[0][j] = Math.max(dp[i-1][j], tmp[0][j-1]) + arr[i][j];
			}
			// 오 -> 왼
			tmp[1][M-1] = arr[i][M-1] + dp[i-1][M-1];
			for (int j = M-2; j >= 0; j--) {
				tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + arr[i][j];
			}
			for (int j = 0; j < M; j++) {
				dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
			}
		}
		System.out.println(dp[N-1][M-1]);

	}
}
