import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayDeque<Integer>> graph = new ArrayList<>();
		int[] edge = new int[N+1];

		StringBuilder sb = new StringBuilder();

		// graph를 초기화
		for (int i = 0; i <N+1; i ++) {
			graph.add(new ArrayDeque<Integer>());
		}

		// graph 그려주기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).offer(B);
			edge[B]++;
		}
		// System.out.println(graph);
		// System.out.println(Arrays.toString(edge));


		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			if (edge[i] == 0) {
				q.offer(i);
			}
		}

		// while 돌면서 que가 빌 때까지 ㄱㄱ
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");
			// 큐를 ArrayDeque로 선언하면 성능이 좋음
			ArrayDeque<Integer> pq = graph.get(now);
			int size = pq.size();
			for (int i = 0; i < size; i ++) {
				int next = pq.poll();
				edge[next]--;
				if (edge[next] == 0) q.offer(next);
			}
		}
		System.out.println(sb.toString());
	}
}

