import java.io.*;
import java.util.*;

// 숨바꼭질 3
public class Main {
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		K = Integer.parseInt(line[1]);
		// System.out.println("N=" +N+ " K=" + K);
		int[] dist = new int[100001];
		boolean[] visited = new boolean[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
		pq.offer(new int[] {N, 0});
		pq.offer(new int[] {2*N, 0});
		dist[N] = 0;
		visited[N] = true;

		int answer = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] == K) {
				answer = now[1];
				break;
			}
			int n1 = now[0]-1;
			int n2 = now[0]+1;
			int n3 = now[0]*2;
			if (!(n1 < 0 || n1 > 100000) && dist[n1] > now[1]+1) {
				// visited[n1] = true;
				dist[n1] = now[1]+1;
				pq.offer(new int[] {n1, now[1]+1});
			}
			if (!(n2 < 0 || n2 > 100000)&& dist[n2] > now[1]+1) {
				// visited[n2] = true;
				dist[n2] = now[1]+1;
				pq.offer(new int[] {n2, now[1]+1});
			}
			if (!(n3 < 0 || n3 > 100000)&& dist[n3] > now[1]) {
				// visited[n3] = true;
				dist[n3] = now[1];
				pq.offer(new int[] {n3, now[1]});
			}
		}
		System.out.println(answer);
	}
}
