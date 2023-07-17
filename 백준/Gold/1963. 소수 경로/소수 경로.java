import java.io.*;
import java.util.*;

public class Main {
	static boolean[] isPrime;

	public static void main(String[] args) throws IOException {
		isPrime = new boolean[10000];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= 100; i++) {
			if (!isPrime[i]) continue;
			for (int j = i+i; j < 10000; j += i) {
				isPrime[j] = false;
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb1 = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int[] visited = new int[10000];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(start);
			while(!q.isEmpty()) {
				int now = q.poll();
				// System.out.println(now);
				if (now == end) break;
				// 자리 수
				for (int i = 0; i < 4; i++) {
					// 바꿀 숫자
					for (int j = 0; j < 10; j++) {
						if(i == 0 && j == 0) continue;
						StringBuilder sb = new StringBuilder(String.valueOf(now));
						sb.setCharAt(i, (char)(j+'0'));
						int changed = Integer.parseInt(sb.toString());
						// 주의!! 조건 빼먹지 않기
						if (changed == now) continue;
						if (isPrime[changed] && visited[changed] == 0) {

							q.offer(changed);
							visited[changed] = visited[now] +1;
						}
					}
				}
			}
			sb1.append(visited[end]+"\n");
		}
		System.out.println(sb1);
	}
}
