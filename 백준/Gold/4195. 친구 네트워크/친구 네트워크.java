import java.io.*;
import java.util.*;

class Main {

	static int[] parent;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			// m번 반복
			parent = new int[m*2];
			cnt = new int[m*2];
			Arrays.fill(cnt, 1);
			int idx = 0;
			for (int j = 0; j < m; j++) {
				String[] str = br.readLine().split(" ");
				// 해시맵에 처음 들어올 때 idx를 부여받음
				if (!map.containsKey(str[0])) {
					// 자신을 부모로 만듦
					parent[idx] = idx;
					map.put(str[0], idx++);
				}
				if (!map.containsKey(str[1])) {
					parent[idx] = idx;
					map.put(str[1], idx++);
				}
				// 합집합 만들기
				union(map.get(str[0]), map.get(str[1]));
				// 보스가 가진 맴버 수 출력
				System.out.println(cnt[find_boss(map.get(str[0]))]);
				// System.out.println(Arrays.toString(cnt));

			}
		}
	}
	public static void union(int a, int b) {
		int a_boss = find_boss(a);
		int b_boss = find_boss(b);
		if(a_boss == b_boss) {
			return;
		}
		parent[b_boss] = a_boss;
		cnt[a_boss] += cnt[b_boss];
	}

	public static int find_boss(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find_boss(parent[a]);
	}
}
