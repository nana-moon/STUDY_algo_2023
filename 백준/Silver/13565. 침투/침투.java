import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int[] dy = {0,0,1,-1};
		int[] dx = {1,-1,0,0};
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int j = 0; j < M; j++) {
			if(arr[0][j] == '0') {
				// bfs 돌려서 2로 바꿈
				q.offer(new int[] {0,j});
				while (!q.isEmpty()) {
					int[] now = q.poll();
					for(int d = 0; d < 4; d++) {
						int ny = dy[d] +now[0];
						int nx = dx[d] +now[1];
						if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
						if (arr[ny][nx] != '0') continue;
						q.offer(new int[] {ny, nx});
						arr[ny][nx] = '2';
					}

				}
			}
		}
		boolean isConnected = false;
		for (int j = 0; j < M; j++) {
			if (arr[N-1][j] == '2') {
				isConnected = true;
			}
		}
		if (isConnected) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
