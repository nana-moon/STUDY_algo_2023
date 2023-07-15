import java.io.*;
import java.util.*;

// 가장 긴 바이토닉 부분 수열
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[2][N];
		dp[0][0] = 1;
		dp[1][N-1] = 1;
		if (N != 1) {
			for (int i = 1; i < N; i++) {
				int max = 0;
				for (int j = 0; j < i; j++) {
					if (numbers[i] > numbers[j]) {
						max = Math.max(max, dp[0][j]);
					}
				}
				if (max == 0) dp[0][i] = 1;
				else {
					dp[0][i] = max +1;
				}
			}
			for (int i = N-2; i >= 0; i--) {
				int max = 0;
				for (int j = N-1; j > i; j--) {
					if (numbers[i] > numbers[j]) {
						max = Math.max(max, dp[1][j]);
					}
				}
				if (max == 0) dp[1][i] = 1;
				else {
					dp[1][i] = max +1;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[0][i] + dp[1][i] -1);
		}
		// System.out.println(Arrays.toString(dp[0]));
		// System.out.println(Arrays.toString(dp[1]));
		System.out.println(answer);
	}

}
