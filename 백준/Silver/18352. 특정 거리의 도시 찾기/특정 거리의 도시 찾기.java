import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

	}
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int K = Integer.parseInt(tmp[2]);
		int X = Integer.parseInt(tmp[3]);
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		graph = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[v].add(new Node(w, 1));
			// System.out.println(graph[v]);
		}

		dijkstra(X);

		// 출력 주의
		StringBuilder sb = new StringBuilder();
		boolean isEmpty = true;
		for (int i = 1; i < N+1; i++) {
			if (dist[i] == K) {
				// 쌍따옴표 주의
				sb.append(i+"\n");
				isEmpty = false;
			}
		}
		System.out.println(isEmpty ? -1 : sb);
	}

	private static void dijkstra(int start) {
		// 초기화
		dist[start] = 0;
		// cost 기준으로 오름차순 정렬
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			// 큐에서 값을 꺼낸다
			int nowIdx = pq.poll().idx;
			// 방문했던 노드라면 continue
			if (visited[nowIdx]) continue;
			// 방문 처리
			visited[nowIdx] = true;
			// 그 노드에서 이어서 갈 수 있는 값들을 돌며 갱신
			for (Node next : graph[nowIdx]) {
				// 갱신된 노드가 있으면 그 노드를 pq에 삽입
				if (next.cost + dist[nowIdx] < dist[next.idx]) {
					dist[next.idx] = next.cost + dist[nowIdx];
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}
}
