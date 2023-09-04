import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] blocks = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			blocks[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				blocks[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		int[][] dp = new int[N+1][H+1];
	/*	0 1 2 3 4 5
		1 0 0 0 0 0
		1 0 1 1 0 1
		1 0 1 2 0 3
		1 1 2 4 3 6*/
		for (int i = 0; i <N+1; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < N+1; i++) {
			for (Integer block : blocks[i]) {
				for (int h = block; h < H+1; h++) {
					dp[i][h] += dp[i-1][h-block];
					dp[i][h] %= 10007;
				}
			}
			for (int j = 1; j < H+1; j++) {
				dp[i][j] += dp[i-1][j];
				dp[i][j] %= 10007;
			}
		}
		// System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N][H]);
	}
}
