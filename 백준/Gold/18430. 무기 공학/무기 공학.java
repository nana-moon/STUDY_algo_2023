import java.util.*;
import java.io.*;
public class Main {
	static int N, M, arr[][], maxVal;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// System.out.println(Arrays.deepToString(arr));
		maxVal = 0;
		dfs(0, 0);
		System.out.println(maxVal);
	}
	public static void dfs (int idx, int value) {
		// System.out.println(value);
		if (idx == N*M) {
			maxVal = Math.max(maxVal, value);
			return;
		}
		int r = idx / M;
		int c = idx % M;

		if (!visited[r][c]) {
			if (r+1 < N && c-1 >= 0 && !visited[r+1][c] && !visited[r][c-1]) {
				visited[r][c-1] = true;
				visited[r+1][c] = true;
				visited[r][c] = true;
				dfs(idx+1, value + arr[r][c]*2 + arr[r+1][c] +arr[r][c-1]);
				visited[r][c-1] = false;
				visited[r+1][c] = false;
				visited[r][c] = false;
			}
			if (r+1 < N && c+1 < M && !visited[r][c+1] && !visited[r+1][c]) {
				visited[r][c+1] = true;
				visited[r+1][c] = true;
				visited[r][c] = true;
				dfs(idx+1, value + arr[r][c]*2 + arr[r+1][c] +arr[r][c+1]);
				visited[r][c+1] = false;
				visited[r+1][c] = false;
				visited[r][c] = false;
			}
			if (r-1 >= 0 && c-1 >= 0 && !visited[r-1][c] && !visited[r][c-1]) {
				visited[r][c-1] = true;
				visited[r-1][c] = true;
				visited[r][c] = true;
				dfs(idx+1, value + arr[r][c]*2 + arr[r-1][c] +arr[r][c-1]);
				visited[r][c-1] = false;
				visited[r-1][c] = false;
				visited[r][c] = false;
			}
			if (r-1 >=0 && c+1 < M && !visited[r-1][c] && !visited[r][c+1]) {
				visited[r-1][c] = true;
				visited[r][c+1] = true;
				visited[r][c] = true;
				dfs(idx+1, value + arr[r][c]*2 + arr[r-1][c] +arr[r][c+1]);
				visited[r-1][c] = false;
				visited[r][c+1] = false;
				visited[r][c] = false;
			}
		}
		// 해당 지점에서 방문 안하는 경우도 체크해야 함!!
		dfs(idx+1, value);
	}
}
