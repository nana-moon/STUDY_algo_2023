import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		int cnt =0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			cnt++;
			now[1] -= 1;
			if (now[1] != 0) {
				q.offer(now);
			} else {
				arr[now[0]] = cnt;
			}
		}
		// System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}
