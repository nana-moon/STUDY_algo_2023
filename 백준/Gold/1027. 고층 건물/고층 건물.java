import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxCnt = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			// 왼쪽 볼 수 있는 빌딩의 수
			cnt += leftCount(i);
			// 오른쪽 볼 수 있는 빌딩의 수
			cnt += rightCount(i);

			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
	public static int leftCount(int idx) {
		if (idx == 0) {
			return 0;
		}
		int building = 0;
		double minSlope = 1000000001;
		for(int i = idx-1; i >= 0; i--) {
			// 기울기를 구함
			double slope = (double)(arr[idx] - arr[i]) / (double)(idx - i);
			if (slope < minSlope) {
				minSlope = slope;
				building++;
			}
		}
		return building;
	}
	public static int rightCount(int idx) {
		if (idx == N-1) {
			return 0;
		}
		int building = 0;
		double maxSlope = -1000000001;
		for(int i = idx+1; i < N; i++) {
			// 기울기를 구함
			double slope = (double)(arr[i] - arr[idx]) / (double)(i - idx);
			if (slope > maxSlope) {
				maxSlope = slope;
				building++;
			}
		}
		return building;
	}
}
