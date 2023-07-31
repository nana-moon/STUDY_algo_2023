import java.util.*;
import java.io.*;

public class Main {
	// 걸그룹 마스터 준석이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, HashSet> map = new HashMap<>();
		for (int g = 0; g < N; g++) {
			String gName = br.readLine();
			int K = Integer.parseInt(br.readLine());
			map.put(gName, new HashSet<String>());
			for (int k = 0; k < K; k++) {
				map.get(gName).add(br.readLine());
			}
			// System.out.println(map.get(gName));
		}
		// 문제 구간
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			String target = br.readLine();
			if (br.readLine().equals("1")) {
				for (String group : map.keySet()) {
					if (map.get(group).contains(target)) {
						sb.append(group + "\n");
						break;
					};
				}
			} else {
				// 자료형에 유의
				HashSet<String> set = map.get(target);
				// ArrayList로 변환 후 정렬
				ArrayList<String> list =  new ArrayList<>(set);
				Collections.sort(list);
				for (String str : list) {
					sb.append(str + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
