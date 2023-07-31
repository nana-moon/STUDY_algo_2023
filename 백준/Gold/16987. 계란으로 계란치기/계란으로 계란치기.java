import java.io.*;
import java.util.*;
public class Main {
	static class Egg{
		int strength;
		int weight;
		public Egg(int strength, int weight) {
			this.strength = strength;
			this.weight = weight;
		}
	}
	static int N;
	static Egg[] eggs;
	static boolean[] broken;
	static int brokenMax = 0;

	// 계란으로 계란치기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		broken = new boolean[N];
		eggs = new Egg[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// System.out.println(eggs[i].strength +" " + eggs[i].weight);
		}

		dfs(0);
		System.out.println(brokenMax);
	}
	public static void dfs(int level) {
		if (level == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (broken[i]) cnt++;
			}
			brokenMax = Math.max(cnt, brokenMax);
			return;
		}
		boolean isNext = false; // 밑으 for문에서도 걸리는 애가 없을 때 강제로 다음 분기로 넘겨줘야 함
		// 이 조건 무조건 필요
		if (broken[level]) {
			dfs(level+1);
		} else {
			for (int i = 0; i < N; i++) {
				if (broken[i] || i == level) continue;
				isNext = true;
				int x = eggs[level].weight;
				int y = eggs[i].weight;
				eggs[level].strength -= y;
				eggs[i].strength -= x;
				boolean egg1 = false;
				boolean egg2 = false;
				if (eggs[level].strength <= 0) {
					broken[level] = true;
					egg1 = true;
				}
				if (eggs[i].strength <= 0) {
					broken[i] = true;
					egg2 = true;
				}
				dfs(level+1);
				if (egg1) {
					broken[level] = false;
				}
				if (egg2) {
					broken[i] = false;
				}
				eggs[level].strength += y;
				eggs[i].strength += x;
			}
		}
		if (!isNext) dfs(level+1);
	}
}
