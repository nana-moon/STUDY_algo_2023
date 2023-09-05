import java.io.*;
import java.util.*;
public class Main {
	static int N, boss[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boss = new int[N+1];
		Arrays.fill(boss,-1);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		// System.out.println(Arrays.toString(boss));
		int answer = 0;
		for(int i  = 2; i<N+1; i++) {
			if(findBoss(i) == 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	public static void union(int a, int b) {
		int aBoss = findBoss(a);
		int bBoss = findBoss(b);
		if (aBoss < bBoss) {
			boss[bBoss] = aBoss;
		} else if (aBoss > bBoss) {
			boss[aBoss] = bBoss;
		}
	}
	public static int findBoss(int a) {
		if(boss[a] == -1) return a;
		int ret = findBoss(boss[a]);
		boss[a] = ret;
		return ret;
	}

}
