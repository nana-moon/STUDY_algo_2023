import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] arr = new long[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
			}
		}
		// System.out.println(Arrays.deepToString(arr));
		long mx = Long.MIN_VALUE;
		for (int c1 = 1; c1 <= m; c1++) {
			for(int c2 = c1; c2 <= m; c2++) {
				long lastMax = 0;
				for (int r = 1; r <= n; r++) {
					// 해당 행만 누적합 한 것 (열 범위는 고정)
					long sum = arr[r][c2] - arr[r][c1-1] - (arr[r-1][c2] - arr[r-1][c1-1]);
					lastMax = Math.max(lastMax + sum, sum); // 해당행 + 이전행까지의 최대값 vs 해당행만
					mx = Math.max(lastMax, mx);
				}
			}
		}
		System.out.println(mx);
	}

}
