import java.io.*;
import java.util.*;
public class Main {
	static int target, min;
	static boolean[] broken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				broken[num] = true;
			}
		}
		min = Math.abs(target - 100);
		for (int i = 0; i < 1000000; i++) {
			String str = Integer.toString(i);

			int len = str.length();
			boolean canMake = true;
			for (int j = 0; j < len; j++) {
				// System.out.println((int) (str.charAt(j)));
				if (broken[str.charAt(j)-'0']) {
					canMake = false;
					break;
				}
			}
			if (canMake) {
				min = Math.min(min, Math.abs(target-i)+len);
			}
		}
		System.out.println(min);

	}
}
