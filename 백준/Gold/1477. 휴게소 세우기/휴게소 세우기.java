import java.io.*;
import java.util.*;
public class Main {
	static int N, M, L;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		arr.add(0);
		arr.add(L);
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		// System.out.println(arr);

		int start = 1;
		int end = L;
		while (start < end) {
			int mid = (start + end) / 2;
			if (canMake(mid)) {
				// m개 이상 만들 수 있음
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);

	}
	public static boolean canMake(int len) {
		int cnt = 0;
		for(int i = 1; i < arr.size(); i++) {
			cnt += (arr.get(i) - arr.get(i-1) -1) / len;
		}
		if (cnt <= M) return true;
		return false;
	}

}
