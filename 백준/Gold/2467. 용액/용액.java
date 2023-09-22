import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int le = 0;
		int ri = N-1;
		int min = Integer.MAX_VALUE;
		int[] minNums = new int[2];
		while (le < ri) {
			int sum = arr[le] + arr[ri];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				minNums[0] = arr[le];
				minNums[1] = arr[ri];
			}
			if (sum >= 0) {
				ri--;
			} else {
				le++;
			}
		}
		// System.out.println(Arrays.toString(minNums));
		StringBuilder sb = new StringBuilder();
		sb.append(minNums[0] + " ").append(minNums[1]);
		System.out.println(sb);
	}
}
