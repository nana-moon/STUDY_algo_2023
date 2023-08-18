import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			StringTokenizer st;
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[N][3];
			// dp[i][0] = OX, dp[i][1] = XO, dp[i][2] = XX > 선택 여부
			dp[0][0] = arr[0][0];
			dp[0][1] = arr[0][1];
			for(int i = 1; i < N; i++) {
				dp[i][0] = arr[i][0] + Math.max(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = arr[i][1] + Math.max(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]);
				dp[i][2] = Math.max(dp[i-1][2], dp[i][2]);
			}
			int max = 0;
			for(int i = 0; i < 3; i++) {
				max = Math.max(max, dp[N-1][i]);
			}
			sb.append(max+"\n");
		}
		System.out.println(sb);
	}
}
