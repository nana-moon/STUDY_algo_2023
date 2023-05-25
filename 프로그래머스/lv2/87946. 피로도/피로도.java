class Solution {
    public static int answer = 0;
	public static boolean[] visited;
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		//dfs로 풀어보자
		dfs(0, k, dungeons);
		return answer;
	}

	private static void dfs(int depth, int k, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {

			if(visited[i] == false && k >= dungeons[i][0]) {
				visited[i] = true;
				dfs(depth+1, k - dungeons[i][1], dungeons);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, depth);
	}
}