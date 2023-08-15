import java.io.*;
import java.util.*;

public class Main {
	// static int N, K;
	// static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] origin = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i < N; i++) {
			pq.offer(origin[i] - origin[i-1]);
		}
		// 그룹화 N-K번 진행하면 그룹이 K개가 된다.
		int cnt =0;
		int result = 0;
		while (cnt < N-K) {
			cnt++;
			result += pq.poll();
		}
		System.out.println(result);
	}
}
