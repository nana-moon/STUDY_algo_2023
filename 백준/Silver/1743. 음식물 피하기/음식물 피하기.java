import java.io.*;
import java.util.*;

public class Main {
	static int N,M, arr[][];
	static boolean[][] visited;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int k = 0; k <K; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a-1][b-1] = 1;
		}
		int max = 0;
		visited = new boolean[N][M];
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		System.out.println(max);
	}
	public static int bfs(int i, int j) {
		visited[i][j] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		int result = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			result++;
			for(int k = 0; k < 4; k++) {
				int ny = dy[k] +now[0];
				int nx = dx[k] +now[1];
				if( ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(visited[ny][nx] || arr[ny][nx] == 0) continue;
				visited[ny][nx] = true;
				q.offer(new int[] {ny,nx});
			}
		}
		// System.out.println(i +" " + j);
		// System.out.println(result);
		return result;
	}
}
