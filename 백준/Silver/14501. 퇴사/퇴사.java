import java.io.*;
import java.util.*;
public class Main {
	static class Consult {
		int start, cost;
		public Consult(int start, int cost) {
			this.start = start;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Consult>[] ends = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			ends[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dur = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// pq.add(new Consult(i, i+dur-1, cost));
			if (i+dur-1 > N) continue;
			ends[i+dur-1].add(new Consult(i, cost));
		}

		int[] dp = new int[N+1];

		for (int end = 1; end < N+1; end++) {
			dp[end] = dp[end-1];
			for (Consult now : ends[end]) {
				dp[end] = Math.max(dp[end], dp[now.start-1] + now.cost);
			}
		}
		// System.out.println(Arrays.toString(dp));
		//
		// int maxVal = 0;
		// for (int i = 1; i < N+1; i++) {
		// 	maxVal = Math.max(maxVal, dp[i]);
		// }
		System.out.println(dp[N]);
	}
}
