import java.util.*;
import java.io.*;

public class Main {
	static int arr[][], R, C;
	static int[][] dir = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int r = 0; r < R; r++) {
			char[] line = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if(line[c] == '.') {
					arr[r][c] = 0;
				} else if(line[c] == 'O') {
					arr[r][c] = 2;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			changeArr();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				char tmp = '.';
				if(arr[i][j] != 0) {
					tmp = 'O';
				}
				sb.append(tmp);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void changeArr() {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 3;
				} else {
					arr[i][j] -= 1;
					if (arr[i][j] == 0) {
						list.add(new int[] {i,j});
					}
				}
			}
		}
		for (int[] a : list) {
			// System.out.println(a[0] +" "+a[1]);
			for (int i = 0; i < 4; i++) {
				int nx = a[0] + dir[i][0];
				int ny = a[1] + dir[i][1];
				if (nx < 0 || nx >=R || ny <0 || ny >= C) continue;
				if(arr[nx][ny] == 0) continue;
				arr[nx][ny] = 0;
			}
		}
	}

}
