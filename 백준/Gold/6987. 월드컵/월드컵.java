import java.io.*;
import java.util.*;

public class Main {
	static int t1[], t2[], win[], draw[], lose[];
	static boolean possible;

	public static void main(String[] args) throws IOException {
		t1 = new int[15];
		t2 = new int[15];
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i+1; j < 6; j++) {
				t1[idx] = i;
				t2[idx] = j;
				idx++;
			}
		}
		// System.out.println(Arrays.toString(t1));
		// System.out.println(Arrays.toString(t2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			int w = 0;
			int d = 0;
			int l = 0;
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				w += win[j];
				l += lose[j];
				d += draw[j];
			}
			// System.out.println(Arrays.toString(win));
			// System.out.println(Arrays.toString(draw));
			// System.out.println(Arrays.toString(lose));
			if (w + d + l != 30) possible = false;
			else {
				possible = false;
				dfs(0);
			}
			if (possible) {
				sb.append(1+" ");
			} else {
				sb.append(0+" ");
			}

		}
		System.out.println(sb);

	}
	static void dfs(int level) {
		// if (possible) return;
		if (level == 15) {
			possible = true;
			return;
		}
		// a와 b설정
		int a = t1[level];
		int b = t2[level];
		// a가 이기는 경우
		if (win[a] > 0 && lose[b] > 0) {
			win[a]--;
			lose[b]--;
			dfs(level+1);
			win[a]++;
			lose[b]++;
		}
		// 비기는 경우
		if (draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			dfs(level+1);
			draw[a]++;
			draw[b]++;
		}
		// 지는 경우
		if (lose[a] > 0 && win[b]>0) {
			lose[a]--;
			win[b]--;
			dfs(level+1);
			lose[a]++;
			win[b]++;
		}
	}
}