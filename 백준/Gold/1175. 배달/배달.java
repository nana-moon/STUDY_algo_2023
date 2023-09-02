import java.io.*;
import java.util.*;
public class Main {
	// visited 굉장히 까다로운 bfs+dp
	static int N, M, minVal, ends[][];
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,-1,0,1};
	static int[][][][] visited;
	static class Node {
		int r,c,cost,dir,past;

		public Node(int r, int c, int cost, int dir, int past) {
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.dir = dir;
			this.past = past;
		}
	}
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		minVal = Integer.MAX_VALUE;
		visited = new int[N][M][4][3];

		boolean result = false;
		int sy = 0;
		int sx = 0;
		ends = new int[2][2];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					Arrays.fill(visited[i][j][k], Integer.MAX_VALUE);
				}
				if (arr[i][j] == 'S') {
					sy = i;
					sx = j;
				} else if (arr[i][j] == 'C') {
					ends[idx][0] = i;
					ends[idx][1] = j;
					idx++;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			visited[sy][sx][i][0] = 0;
		}
		result = bfs(sy,sx);
		if (!result) {
			System.out.println(-1);
		} else {
			System.out.println(minVal);
		}
	}
	public static boolean bfs(int a, int b) {
		boolean result = false;
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(new Node(a,b,0,-1,0));
		while (!q.isEmpty()) {
			Node n = q.poll();
			boolean flag = false;
			if (n.r == ends[0][0] && n.c == ends[0][1] && n.past != 1) {
				n.past += 1;
				flag = true;
			}
			if (n.r == ends[1][0] && n.c == ends[1][1] && n.past != 2) {
				n.past += 2;
				flag = true;
			}
			if (flag) {
				if (n.past == 3) {
					result = true;
					minVal = Math.min(minVal, n.cost);
					break;
				} else {
					visited[n.r][n.c][n.dir][n.past] = n.cost;
				}
			}
			for (int i = 0; i < 4; i++) {
				if(i == n.dir) continue;
				int ny = dy[i] + n.r;
				int nx = dx[i] + n.c;
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if (arr[ny][nx] == '#') continue;

				if (visited[ny][nx][i][n.past] <= n.cost+1) continue;
				visited[ny][nx][i][n.past] = n.cost+1;

				q.offer(new Node(ny,nx,n.cost+1,i, n.past));
			}
		}
		return result;
	}
}
