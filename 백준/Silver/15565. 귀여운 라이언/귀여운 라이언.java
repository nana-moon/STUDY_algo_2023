import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				cnt ++;
			}
			if (map.containsKey(cnt)) {
				map.put(cnt, map.get(cnt)+1);
			} else {
				map.put(cnt, 1);
			}
		}
		int size = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		boolean possible = false;
		for (int i = 1; i <= cnt; i++) {
			size++;
			// System.out.println(i);
			sum += map.get(i);

			if (size == K) {
				size--;
				sum -= map.get(i-(K-1));
			}
			if (size == K-1 && map.containsKey(i+1)) {
				min = Math.min(min, sum+1);
				possible = true;
				
			}
		}
		if (possible)
			System.out.println(min);
		else
			System.out.println(-1);
	}
}
