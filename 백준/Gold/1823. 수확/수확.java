import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp;
	static int[] rice;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[2001][2001];
		rice = new int[2001];
		for (int i = 1;i <= N; i++) {
			rice[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(harvest(1, N, 1));


	}
	// dp [y][x] = 현재 남은 벼가 y인덱스부터 x인덱스까지이고 order번째 수확할 순서일 때 최대 이익
	private static int harvest(int start, int end, int order) {
		if (start > end) return 0;
		if (dp[start][end] != 0) return dp[start][end];
		int left = rice[start]*order + harvest(start+1, end, order+1);
		int right = rice[end]*order + harvest(start, end-1, order+1);
		dp[start][end] = Math.max(left, right);
		return dp[start][end];

	}

}
