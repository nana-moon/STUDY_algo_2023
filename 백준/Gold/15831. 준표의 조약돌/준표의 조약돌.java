import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		int[] b_cnt = new int[str.length()+1];
		int[] w_cnt = new int[str.length()+1];
		for (int i = 1; i <= str.length(); i++) {
			b_cnt[i] = b_cnt[i-1];
			w_cnt[i] = w_cnt[i-1];
			if (str.charAt(i-1) == 'B') {
				b_cnt[i]++;
			} else {
				w_cnt[i]++;
			}
		}
		// System.out.println(Arrays.toString(b_cnt));
		// System.out.println(Arrays.toString(w_cnt));
		int answer = 0;
		boolean stop = false;
		for (int len = N; len >= 1; len--) {
			for (int start = 0; start <= N-len; start++) {
				int end = start + len;
				int counted_b = b_cnt[end] - b_cnt[start];
				int counted_w = w_cnt[end] - w_cnt[start];
				// System.out.println(counted_b +" " +counted_w);
				if (counted_w >= W && counted_b <= B) {
					answer = len;
					stop = true;
					break;
				}
			}
			if (stop) break;
		}
		System.out.println(answer);
	}
}
