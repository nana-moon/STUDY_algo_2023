import java.io.*;
import java.util.*;

// 아직 덜 품
public class Main {
	static class Node {
		int r, c, attack, cost;
		Node (int r, int c, int attack, int cost) {
			this.r = r;
			this.c = c;
			this.attack = attack;
			this.cost = cost;
		}
	}

	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int minVal = Integer.MAX_VALUE;
		// cost = new int[N][M];
		for (int i = 0; i < N; i++) {
			// Arrays.fill(cost[i], Integer.MAX_VALUE);
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				// char > 변환
				arr[i][j]= line[j] - '0';
			}
		}
		// System.out.println(Arrays.deepToString(arr));
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		// visited 배열을 3차원으로 해서 깬적 있는 경우, 깬 적 없는 경우 두 가지로 나눠 생각
		boolean[][][] visited = new boolean[N][M][2];
		Queue<Node> q = new ArrayDeque<>();
		// cost[0][0] = 1;
		q.offer(new Node(0,0,1,1));

		while (!q.isEmpty()) {
			Node now = q.poll();
			// System.out.println(now.r + " "+ now.c);
			if (now.r == N-1 && now.c == M-1) {
				minVal = Math.min(now.cost, minVal);
				break;
			}
			// System.out.println(now.r+ " " + now.c + " " + now.attack);
			for (int i = 0; i < 4; i++) {
				int nx = now.r + dir[i][0];
				int ny = now.c + dir[i][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (arr[nx][ny] == 1 && now.attack == 0) continue;

				if (arr[nx][ny] == 1) {
					// System.out.println(now.attack);
					// 벽 부수고 이동
					visited[nx][ny][1] = true; // visited 확인 안하는 경우
					q.offer(new Node(nx,ny, now.attack-1, now.cost+1));
				} else {
					// 0일 경우
					// 벽을 부순적 있음, 방문 안함
					if(now.attack == 0 && !visited[nx][ny][1]) {
						q.offer(new Node(nx,ny, now.attack, now.cost+1));
						visited[nx][ny][1] = true;
					// 벽을 부순적 없음, 방문안함
					} else if (now.attack == 1 && !visited[nx][ny][0]) {
						q.offer(new Node(nx,ny, now.attack, now.cost+1));
						visited[nx][ny][0] = true;
					}

				}

			}
		}
		if (minVal == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minVal);
		}
	}
}
