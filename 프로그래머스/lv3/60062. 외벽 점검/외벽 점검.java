import java.io.*;
import java.util.*;

class Solution {
    static int answer;
	static int[] weaks;
	// 외벽 점검
	public static void main(String[] args) {
		int result = solution(12, new int[] {1, 3, 4, 9, 10}, new int[] {3, 5, 7});
		System.out.println(result);
	}
	public static int solution(int n, int[] weak, int[] dist) {
		answer = Integer.MAX_VALUE;
		weaks = new int[weak.length*2];
		for (int i = 0; i < weak.length; i++) {
			weaks[i] = weak[i];
			weaks[i+weak.length] = n + weak[i];
		}
		System.out.println(Arrays.toString(weaks));
		

		for (int i = 0; i < weak.length; i++) {
			dfs(i, 0, dist, new boolean[dist.length], new int[dist.length]);
		}
        if (answer == Integer.MAX_VALUE) return -1;
		return answer;
	}

	private static void dfs(int start, int depth,int[] dist, boolean[] visited, int[] permuted) {
		if (depth == dist.length) {
			answer = Math.min(answer, check(start, start+ weaks.length/2, permuted));
			return;
		}
		for (int i = 0; i < dist.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			permuted[depth] = dist[i];
			dfs(start, depth+1, dist, visited, permuted);
			visited[i] = false;
		}
	}

	static int check(int start, int end, int[] friends) {
		int cnt = 1;
		int pos = weaks[start] + friends[cnt-1];
		for (int i = start; i < end; i ++) {
			if (pos < weaks[i]) {
				cnt++;
				if (cnt > friends.length) return Integer.MAX_VALUE;
				pos = weaks[i] + friends[cnt-1];
			}
		}
		return cnt;
	}
}