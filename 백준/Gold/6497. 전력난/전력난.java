import java.io.*;
import java.util.*;

public class Main {
	static int N, M, boss[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;

			int[][] lines = new int[M][3];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				lines[i][0] = Integer.parseInt(st.nextToken());
				lines[i][1] = Integer.parseInt(st.nextToken());
				lines[i][2] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(lines, (o1, o2) -> o1[2] - o2[2]);

			boss = new int[N];
			Arrays.fill(boss, -1);

			long saving = 0;
			for (int i = 0; i < M; i++) {
				boolean result = union(lines[i][0], lines[i][1]);
				if (!result) {
					saving += lines[i][2];
					// System.out.println(saving);
				}
			}
			sb.append(saving + "\n");
		}
		System.out.println(sb);
	}
	public static boolean union(int x, int y) {
		// System.out.println(x+ " "+y);
		int xBoss = findBoss(x);
		int yBoss = findBoss(y);
		if (xBoss == yBoss) return false;
		boss[yBoss] = xBoss;
		return true;
	}
	public static int findBoss(int a) {
		if (boss[a] == -1) return a;
		int ret = findBoss(boss[a]);
		boss[a] = ret;
		return ret;
	}
}
