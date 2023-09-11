import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		for (int end = 0; end < N; end++) {
			sum += arr[end];
			if (sum >= K) {
				minLen = Math.min(minLen, end-start+1);
				// start를 증가 시켜야 함
				while (sum >= K) {
					minLen = Math.min(minLen, end-start+1);
					sum -= arr[start];
					start += 1;
				}
			}
			// end를 증가시키기 위해 다음 for문으로
		}
		if (minLen == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minLen);
		}
	}
}
