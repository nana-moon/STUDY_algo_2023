import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char[][] arr;
	static ArrayList<int[]> teachers;
	static boolean isValid;

	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		teachers = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().replace(" ","").toCharArray();
			for(int j = 0; j < N; j++) {
				if (arr[i][j] == 'T') {
					teachers.add(new int[] {i,j});
				}
			}
		}
		isValid = false;
		dfs(0);
		if(isValid)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	public static void dfs(int level) {
		if(isValid) return;
		if (level == 3) {
			if (checkValid(arr)) {
				isValid = true;
				// System.out.println(Arrays.deepToString(arr));
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				if(arr[i][j] != 'X') continue;
				arr[i][j] = 'O';
				dfs(level+1);
				arr[i][j] = 'X';
			}
		}
	}
	public static boolean checkValid(char[][] arr) {
		for(int[] node : teachers) {
			for(int d = 0; d < 4; d++) {
				for(int i = 1; i < N; i++) {
					int ny = dy[d]*i + node[0];
					int nx = dx[d]*i + node[1];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) break;
					if(arr[ny][nx] == 'O') break;
					if(arr[ny][nx] == 'S' ) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
