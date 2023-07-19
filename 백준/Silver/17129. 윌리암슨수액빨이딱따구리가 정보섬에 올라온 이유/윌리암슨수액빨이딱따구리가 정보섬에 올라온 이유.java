import java.util.*;
import java.io.*;
import java.util.jar.JarOutputStream;

public class Main {
	static char[][] arr;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j =0; j < M; j++) {
				if (arr[i][j] =='2') {
					int result = bfs(i,j);
					if (result == 0) {
						sb.append("NIE");
					} else {
						sb.append("TAK" + "\n");
						sb.append(result);
						// System.out.println(result);
					}
					break;
				}
			}
		}
		System.out.println(sb);

	}

	private static int bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,0});
		visited[i][j] = true;
		ArrayList<Character> check = new ArrayList<>();
		check.add('3');
		check.add('4');
		check.add('5');
		int result = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (check.contains(arr[now[0]][now[1]])) {
				result = now[2];
				break;
			}
			for (int d =0; d < 4; d++) {
				int ny = dir[d][0] + now[0];
				int nx = dir[d][1] + now[1];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if (visited[ny][nx] || arr[ny][nx] == '1') continue;
				visited[ny][nx] = true;
				q.offer(new int[] {ny,nx, now[2]+1});
			}
		}
		return result;

	}
}
