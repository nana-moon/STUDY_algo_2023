import java.io.*;
import java.util.*;

public class Main {
	static  int N, K, tools[], answer, weight;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tools = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tools[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		answer = 0;
		weight = 500;
		dfs(0);
		System.out.println(answer);
	}
	public static void dfs(int level) {
		if (level == N) {
			answer += 1;
			return;
		}
		int origin = weight;
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if(weight-K+tools[i] >= 500) {
				visited[i] = true;
				weight = weight - K + tools[i];
				dfs(level+1);
				weight = origin;
				visited[i] = false;
			}
		}
	}
}
