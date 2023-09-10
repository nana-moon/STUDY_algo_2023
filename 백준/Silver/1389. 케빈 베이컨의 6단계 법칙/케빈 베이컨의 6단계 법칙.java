import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[][] dist;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		dist = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		visited = new boolean[N+1][N+1];

		for(int i = 1; i < N+1; i++) {
			dijkstra(i);
		}
		int minIdx = N+1;
		int minVal = M*N;
		for(int i = 1; i < N+1; i++) {
			int sum = 0;
			for(int j = 1; j < N+1; j++) {
				sum += dist[i][j];
			}
			if (minVal > sum) {
				minVal = sum;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
	public static void dijkstra(int start) {
		// 시작점 초기화
		dist[start][start] = 0;
		// pq
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			// 방문한 노드면 넘어감
			if (visited[start][now]) continue;
			// 방문 처리
			visited[start][now] = true;
			for(int next : graph[now]) {
				if (dist[start][next] > dist[start][now]+1) {
					dist[start][next] = dist[start][now]+1;
					q.offer(next);
				}
			}

		}
	}
}
