import java.io.*;
import java.util.*;
public class Main {
	static int N, M, arr[][], visited[][], answer;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		answer = 0;
		for(int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if (line[j] == 'U') {
					arr[i][j] = 0;
				} else if (line[j] == 'D') {
					arr[i][j] = 1;
				} else if (line[j] == 'L') {
					arr[i][j] = 2;
				} else {
					arr[i][j] = 3;
				}
			}
		}
		// System.out.println(Arrays.deepToString(arr));
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (visited[i][j] == 0) {
					cnt++;
					if (checkNew(i,j,cnt)) answer++;
					// System.out.println(Arrays.deepToString(visited));
				}
			}
		}
		System.out.println(answer);
	}
	public static boolean checkNew(int i, int j, int val) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		visited[i][j] = val;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int ny = dy[arr[now[0]][now[1]]] + now[0];
			int nx = dx[arr[now[0]][now[1]]] + now[1];
			if (ny < 0 || nx < 0 || ny >=N || nx >= M) {
				return true;
			}
			if (visited[ny][nx] != 0) {
				if (visited[ny][nx] != val) {
					return false;
				} else {
					return true;
				}
			} else {
				visited[ny][nx] = val;
				q.offer(new int[] {ny, nx});
			}
		}
		return true;
	}
}
