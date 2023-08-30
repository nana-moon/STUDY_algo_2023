import java.io.*;
import java.util.*;
public class Main {
	// 난이도 높음
	static int N, K, minLV, cnt;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		cnt = 0;
		minLV = Integer.MAX_VALUE;
		bfs(0,N);
		System.out.println(minLV);
		System.out.println(cnt);
	}
	public static void bfs(int level, int x) {
		visited[x] = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {level,x});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] > minLV) continue;
			if (now[1] == K) {
				minLV = now[0];
				cnt += 1;
				continue;
			}
			for(int i =  0; i < 3; i++) {
				int nx = now[1];
				if (i == 0) nx -= 1;
				else if (i == 1) nx += 1;
				else if (i == 2) nx *= 2;
				if (nx < 0 || nx > 100000) continue;
				if (visited[nx] == 0 || visited[nx] == now[0]+1) {
					visited[nx] = now[0]+1;
					q.offer(new int[] {now[0]+1, nx});
				}
			}
		}
	}
}
