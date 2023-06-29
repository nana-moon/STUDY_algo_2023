import java.io.*;
import java.util.*;
public class Main {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+w];
		st = new StringTokenizer(br.readLine());
		for (int i = w; i < n+w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// System.out.println(Arrays.toString(arr));
		int cnt = 0; // 통과한 트럭의 수
		int start = 0; // 다리 시작 위치
		int end = start+w; // 다리 끝 +1 위치
		int sec = 0;
		while (cnt < n) {
			sec++;
			boolean can_move = false;
			if (end+1 <= arr.length) {
				int n_ed = end+1;
				int n_st = start+1;
				int sum = 0;
				for (int i = n_st; i < n_ed; i++) {
					sum += arr[i];
				}
				if (sum <= L) {
					if (arr[start] != 0) cnt++;
					start = n_st;
					end = n_ed;
					can_move = true;
				}
			}
			if (!can_move) {
				// 그냥 다리에 있는 거만 옮김
				if (arr[start] != 0) cnt ++;
				for (int i = start; i < end-1; i++) {
					arr[i] = arr[i+1];
				}
				arr[end-1] = 0;
			}
			// System.out.println(arr);

		}
		System.out.println(sec);

	}
}
