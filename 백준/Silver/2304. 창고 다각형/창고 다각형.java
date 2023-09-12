import java.io.*;
import java.util.*;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int maxH = 0;
		int maxIdx = 0;
		int maxP = 0;
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr.add(new int[] {p,h});
			if (maxH < h) {
				maxH = h;
				maxIdx = p;
			}
			maxP = Math.max(maxP, p);
		}
		int[] roof = new int[maxP+1];
		for (int[] ar : arr) {
			roof[ar[0]] = ar[1];
		}
		// System.out.println(Arrays.toString(roof));

		int now = 0;
		boolean stop = false;
		for (int i = 0; i <= maxP; i++) {
			if (roof[i] > now) {
				now = roof[i];
			}
			if (now == maxH && maxIdx == i) stop = true;
			roof[i] = now;
			if (stop) break;
		}
		now = 0;
		stop = false;
		for (int i = maxP; i >= 0; i--) {
			if (roof[i] > now) {
				now = roof[i];
			}
			if (now == maxH && maxIdx == i) stop = true;
			roof[i] = now;
			if (stop) break;
		}
		int total = 0;
		for(int i = 0; i < maxP+1; i++) {
			total += roof[i];
		}
		System.out.println(total);
		// System.out.println(Arrays.toString(roof));
	}
}
