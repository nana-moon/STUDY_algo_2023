import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	// 비교 가능한 class 만들기
	static class Bag implements Comparable<Bag>{
		int weight, value;
		public Bag(int w, int v) {
			this.weight = w;
			this.value = v;
		}
		@Override
		public int compareTo(Bag b1) {
			// String 비교 방법이랑 다름
			int result = Integer.compare(this.weight, b1.weight); // x < y 일 때 음수 리턴
			if (result == 0) {
				return Integer.compare(this.value, b1.value);
			}
			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ArrayList<Bag> list = new ArrayList<>();
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Bag(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		// 정렬
		Collections.sort(list);
		for (int i = 1; i < N+1; i++) {
			Bag bag = list.get(i-1);
			for (int j = 1; j < K+1; j++) {
				// 용량이 가방의 무게 보다 작으면
				if (j < bag.weight) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				} else {
					// 가방을 넣는 경우
					int aCase = dp[i-1][j-bag.weight] + bag.value;
					// 가방을 넣지 않는 경우
					int bCase = Math.max(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.max(aCase, bCase);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
