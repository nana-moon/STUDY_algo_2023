import java.util.*;
import java.io.*;
// 사회망 서비스(SNS)
public class Main {
	static int N, dp[][];
	static boolean[] visited;
	static ArrayList<Integer>[] tree; // 초기화 형태 기억!! 자료형 써주기
	// static int minVal = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for (int i =0; i <N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i =0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree[x].add(y);
			tree[y].add(x);
		}
		// System.out.println(Arrays.toString(tree));
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		dfs(1); // 루트 노드를 1로
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	public static void dfs(int parent) {
		visited[parent] = true;
		dp[parent][0] = 0; // 얼리어답터가 아닌 경우
		dp[parent][1] = 1; // 얼리어답터인 경우
		for (int child : tree[parent]) {
			if (visited[child]) continue;
			dfs(child);
			dp[parent][0] += dp[child][1];
			dp[parent][1] += Math.min(dp[child][0], dp[child][1]);
		}
	}
}
