import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> similar = new HashMap<>();
		for (int i =0; i < N; i++) {
			HashMap<Character, Integer> alpha = new HashMap<>();
			String str = br.readLine();
			String changed = "";
			int num = 0;
			for (int j = 0; j < str.length(); j++) {
				char w = str.charAt(j);

				if (alpha.containsKey(w)) {
					// 있으면 그거 그대로
					int tmp = alpha.get(w);
					changed += tmp;
				} else {
					// 없으면 +1 맵에 넣고 그 값으로
					num++;
					alpha.put(w, num);
					changed += num;
				}
			}
			// 바꾼 문자열이 있으면 +1 , 없으면 새로 만들기
			if (similar.containsKey(changed)) {
				similar.put(changed, similar.get(changed)+1);
			} else {
				similar.put(changed, 1);
			}
		}
		int result = 0;
		for (Integer value : similar.values()) {
			if (value >= 2) {
				result += value*(value-1) / 2;
			}
		}
		System.out.println(result);
	}
}
