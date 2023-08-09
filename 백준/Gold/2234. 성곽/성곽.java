import java.io.*;
import java.util.*;
public class Main {
	static int N,M, mSize, cnt, mBroken;
	static int[][][] castle;
	static boolean[][] visited;
	static int[][] four = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		// 서 1, 북 2, 동 4, 남 8
		// 성의 방의 개수
		// 가장 넒은 방의 넓이
		// 하나의 벽을 제거 했을 때 가장 큰 방의 크기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		castle = new int[M][N][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				int[] dict = new int[4];
				int idx = 0;
				int div = 8;
				while (idx < 4) {
					if (num / div == 1) {
						dict[idx] = 1;
					} else {
						dict[idx] = 0;
					}
					num %= div;
					idx ++;
					div /= 2;
				}
				castle[i][j] = dict;
			}
		}
		mSize = 0;
		cnt = 0;
		mBroken = 0;
		visited = new boolean[M][N];
		for (int i = 0; i <M; i++) {
			for (int j = 0; j <N; j++) {
				if (!visited[i][j]) {
					cnt++;
					mSize = Math.max(bfs(i, j), mSize);

				}
			}
		}

		for (int i = 0; i <M; i++) {
			for (int j = 0; j <N; j++) {
				for (int k = 0; k <4; k++) {
					if (castle[i][j][k] == 1) {
						visited = new boolean[M][N];
						castle[i][j][k] = 0;
						mBroken = Math.max(mBroken, bfs(i,j));
						castle[i][j][k] = 1;
					}
				}
			}
		}

		System.out.println(cnt + "\n" + mSize + "\n" +mBroken);
	}
	public static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		int result = 1;
		q.offer(new int[] {i,j}); // y, x
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int[] nowDict = castle[now[0]][now[1]]; // 남, 동, 북, 서
			for (int d = 0; d < 4; d++) {
				if (nowDict[d] != 0) continue;
				int ny = now[0] + four[d][0];
				int nx = now[1] + four[d][1];
				if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
				if (visited[ny][nx]) continue;
				result += 1;
				visited[ny][nx] = true;
				q.offer(new int[] {ny,nx});
			}
		}
		return result;
	}

}
