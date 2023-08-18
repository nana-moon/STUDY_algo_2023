import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// System.out.println(Arrays.deepToString(arr));
		int[][] dp = new int[N][N];
		dp[0] = arr[0];
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j <= i; j++) {
				dp[i+1][j] = Math.max(arr[i+1][j] + dp[i][j], dp[i+1][j]);
				dp[i+1][j+1] = Math.max(arr[i+1][j+1] + dp[i][j], dp[i+1][j+1]);
			}
		}
		// System.out.println(Arrays.deepToString(dp));
		int max = 0;
		for(int j = 0; j < N; j++) {
			max = Math.max(max, dp[N-1][j]);
		}
		System.out.println(max);

	}
}
