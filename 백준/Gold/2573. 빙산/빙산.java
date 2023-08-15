import java.io.*;
import java.util.*;
public class Main {
	static int N,M,arr[][];
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		int cnt = 0;
		boolean stop = false;
		while (stop == false) {
			melting();
			year ++;
			cnt = checkCnt();
			// System.out.println(Arrays.deepToString(arr));
			if(cnt >= 2 || cnt == 0) {
				stop = true;
			}
		}
		if(cnt == 0) {
			System.out.println(cnt);
		} else {
			System.out.println(year);
		}
	}
	public static void melting() {
		int[][] zeroMap = new int[N][M];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				int zCnt = 0;
				for(int k = 0; k <4; k++) {
					int ny = dy[k] + i;
					int nx = dx[k] + j;
					if(nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
					if(arr[ny][nx] == 0) zCnt += 1;
				}
				zeroMap[i][j] = zCnt;
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				if(arr[i][j] != 0) {
					int result = (arr[i][j] - zeroMap[i][j] >= 0)  ? arr[i][j] - zeroMap[i][j] : 0;
					arr[i][j] = result;
				}
			}
		}
	}
	public static int checkCnt() {
		boolean[][] visited = new boolean[N][M];
		int result =0;
		for(int i = 0; i <N; i++) {
			for(int j =0; j < M; j++) {
				if (arr[i][j] != 0 && !visited[i][j]) {
					result += 1;
					// bfs
					visited[i][j] = true;
					ArrayDeque<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {i,j});
					while (!q.isEmpty()) {
						int[] now = q.poll();
						for(int k = 0; k <4; k++) {
							int ny = dy[k] +now[0];
							int nx = dx[k] +now[1];
							if(nx < 0 || ny < 0 || ny >= N || nx >= M || visited[ny][nx]) continue;
							if(arr[ny][nx] != 0) {
								visited[ny][nx] = true;
								q.offer(new int[] {ny,nx});
							}
						}
					}
				}
			}
		}
		return result;
	}
}
