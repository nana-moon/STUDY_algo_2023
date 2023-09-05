import java.io.*;
import java.util.*;
public class Main {
	static int N, r, c;
	static long cnt;
	static boolean stop;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt = -1;
		stop = false;
		dfs(0,0, (int)Math.pow(2, N));
		System.out.println(cnt);
	}
	public static void dfs(int sr, int sc, int len) {
	
		if (len == 1) {
			cnt++;
			return;
		}

		int half = len/2;
		long tmp = (len*len) / 4;

		if (sr <= r && r < sr+half && sc <= c && c < sc+half) {
			// 1구역에 속함
			dfs(sr,sc, half);
		} else if (sr <= r && r < sr+half && sc+half <= c && c < sc+half*2) {
			// 2
			cnt += tmp*1;
			dfs(sr,sc+half, half);
		} else if (sr+half <= r && r < sr+half*2 && sc <= c && c < sc+half) {
			// 3
			cnt += tmp*2;
			dfs(sr+half,sc, half);
		} else {
			// 4
			cnt += tmp*3;
			dfs(sr+half,sc+half, half);
		}
	}
}
