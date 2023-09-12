import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] canGo = new int[N+2];
		for(int i = 1; i < N+1; i++) {
			canGo[i] = Integer.parseInt(br.readLine());
		}
		int[][][] dp = new int[N+2][M+1][2]; // 현재 시간 / 지침 지수 / 쉬는 중 or 달리는 중
		for (int i = 2; i <= N+1; i++) {
			for (int j = 0; j < M+1; j++) {
				if (j-1 >= 0) {
					// 달렸다가 달리기
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j-1][1] + canGo[i-1]);
					// 쉬었다가 달리기
					if (j-1 == 0) {
						dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j-1][0] + canGo[i-1]);
					}
				}
				if (j+1 <= M) {
					// 쉬었다가 쉬기
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j+1][0]);
					// 달렸다가 쉬기
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j+1][1]);
				}
				if (j == 0) {
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][0][0]);
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][0][1]); // 없어도 될듯
				}
			}

		}
		// System.out.println(Arrays.deepToString(dp));
		System.out.println(Math.max(dp[N+1][0][0], dp[N+1][0][1]));
		// System.out.println(dp[N+1][0][1]);
	}
}
