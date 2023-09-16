import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][2];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 1; i < N+1; i++) {
			arr[i][1] = Integer.parseInt(st.nextToken());
			sum += arr[i][1];
		}
		int[][] dp = new int[N+1][sum+1];

		for(int i = 1; i < N+1; i++) {
			int size = arr[i][0];
			int cost = arr[i][1];
			for(int j = 0; j < sum+1; j++) {
				if (j < cost) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], size + dp[i-1][j-cost]);
				}
			}
		}
		// System.out.println(Arrays.deepToString(dp));
		int minC = 0;
		boolean stop = false;
		for(int j = 0; j < sum+1; j++) {
			for(int i = 1; i < N+1; i++) {
				if (dp[i][j] >= M) {
					minC = j;
					stop = true;
					break;
				}
			}
			if(stop) break;
		}
		System.out.println(minC);
	}
}
