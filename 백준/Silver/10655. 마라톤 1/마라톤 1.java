import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		int preX = 0;
		int preY = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if (i != 0) {
				sum += Math.abs(preX-arr[i][0]);
				sum += Math.abs(preY-arr[i][1]);
			}
			preX = arr[i][0];
			preY = arr[i][1];
		}
		// System.out.println(sum);
		long answer = Long.MAX_VALUE;
		for (int i = 1; i < N-1; i++) {
			int gap = 0;
			gap += Math.abs(arr[i-1][0]-arr[i][0]);
			gap += Math.abs(arr[i][0]-arr[i+1][0]);
			gap += Math.abs(arr[i-1][1]-arr[i][1]);
			gap += Math.abs(arr[i][1]-arr[i+1][1]);
			gap -= Math.abs(arr[i-1][0]-arr[i+1][0]);
			gap -= Math.abs(arr[i-1][1]-arr[i+1][1]);
			answer = Math.min(answer, sum - gap);
		}
		System.out.println(answer);
	}
}
