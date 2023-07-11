import java.util.*;

class Solution {
    static char[][] arr;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int t = 0; t < 5; t++) {
			if (check_distance(places[t])) answer[t] = 1;
			else answer[t] = 0;
		}
		return answer;
	}
	public static boolean check_distance(String[] place) {
		arr = new char[5][5];
		for (int i= 0; i < 5; i++) {
			arr[i] = place[i].toCharArray();
		}
		for (int i = 0; i < 5; i++) {
			for (int j=0; j<5; j++) {
				if (arr[i][j] == 'P') {
					if (!bfs(i, j)) return false;
				}
			}
		}
		return true;
	}

	private static boolean bfs(int x, int y) {
		boolean[][] visited = new boolean[5][5];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y, 0});
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// System.out.println(Arrays.toString(now));
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dir[i][0];
				int ny = now[1] + dir[i][1];
				if (0 > ny || 0 > nx || ny >= 5 || nx >= 5) continue;
				// System.out.println("nx = " + nx + "ny =" + ny);
				if (visited[nx][ny]) continue;
				if (arr[nx][ny] == 'X') continue;
				else if (arr[nx][ny] == 'O') {
					q.offer(new int[] {nx, ny, now[2]+1});
					visited[nx][ny] = true;
				} else {
					if (now[2]+1 <= 2) return false;
				}

			}
		}
		return true;
	}
}