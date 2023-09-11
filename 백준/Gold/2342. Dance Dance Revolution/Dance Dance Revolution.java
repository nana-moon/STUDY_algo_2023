import java.io.*;
import java.util.*;
public class Main {
	static int ddr[], N, dp[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = tmp.length-1;
		ddr = new int[N];
		for (int i = 0; i < N; i++) {
			ddr[i] = Integer.parseInt(tmp[i]);
		}
		// System.out.println(Arrays.toString(ddr));
		dp = new int[N+1][5][5];

		// minForce = Integer.MAX_VALUE; // 최소 힘

		int result = dfs(0, 0, 0);
		System.out.println(result);


	}
	public static int dfs(int left, int right, int level) {
		if (level == N) {
			return 0;
		}
		if (dp[level][left][right] != 0) {
			return dp[level][left][right];
		}
		int leftForce = dfs(ddr[level], right, level+1) + costReturn(left, ddr[level]);
		int rightForce = dfs(left, ddr[level], level+1) + costReturn(right, ddr[level]);
		dp[level][left][right] = Math.min(leftForce, rightForce);
		return dp[level][left][right];
	}
	public static int costReturn(int start, int end) {
		if (start == 0) return 2;
		if (start == end) return 1;
		if (Math.abs(start - end) == 2) return 4;
		return 3;
	}
}


