import java.io.*;
import java.util.*;
public class Main {
	// bottom-up 방식!!
	static class Node {
		int n, cost;
		public Node (int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}
	static int V, maxSum;
	static ArrayList<Node>[] tree;

	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V+1];
		StringTokenizer st;
		for (int i = 1; i < V+1; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			tree[v] = new ArrayList<>();
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if(n == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				tree[v].add(new Node(n, cost));
			}
		}
		// System.out.println(Arrays.toString(tree));
		maxSum = 0;
		visited = new boolean[V+1];
		visited[1] = true;
		dfs(1);
		System.out.println(maxSum);
	}
	public static int dfs(int v) {
		int max1 = 0;
		int max2 = 0;
		for(Node next : tree[v]) {
			if(visited[next.n]) continue;
			visited[next.n] = true;
			int result = dfs(next.n);
			visited[next.n] = false;
			result += next.cost;
			if (result > max1) {
				// 꼭 최대값을 옮겨줘야함
				max2 = max1;
				max1 = result;
			} else if (result > max2) {
				max2 = result;
			}
		}
		maxSum = Math.max(maxSum, max1+max2);
		return max1;
	}
}
