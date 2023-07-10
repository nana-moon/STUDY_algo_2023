import java.util.*;
import java.io.*;

public class Main {
	static int N, tall_cnt[], numbers[], answer[];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tall_cnt = new int[N];
		numbers = new int[N];
		answer = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			tall_cnt[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i =0; i < N; i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);


	}

	private static void dfs(int level) {
		if (level == N) {
			boolean result = check_answer(numbers);
			if (result) answer = Arrays.copyOf(numbers, N);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			numbers[level] = i+1;
			dfs(level+1);
			visited[i] = false;
		}

	}

	private static boolean check_answer(int[] numbers) {
		for (int i = N-1; i >= 0; i--) {
			int cnt = 0;
			int me = numbers[i];
			for (int j = 0; j < i; j++) {
				if (numbers[j] > me) cnt++;
			}
			if (cnt != tall_cnt[me-1]) return false;
		}
		return true;
	}

}
