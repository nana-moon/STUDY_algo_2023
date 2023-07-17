import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lectures = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lectures[i][0] = Integer.parseInt(st.nextToken());
			lectures[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lectures, (o1,o2)-> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		// System.out.println(Arrays.deepToString(lectures));

		int end = lectures[0][1];
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (lectures[i][0] >= end) {
				cnt ++;
				end = lectures[i][1];
			}
		}
		System.out.println(cnt);
	}
}
