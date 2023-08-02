import java.util.*;
import java.io.*;

public class Main {
	static int N, lights[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		lights = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			changeLights(sex, num);
		}
		// System.out.println(Arrays.toString(lights));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for ( int i = 1; i < N+1; i++) {
			cnt ++;
			sb.append(lights[i] + " ");
			if (cnt == 20) {
				sb.append("\n");
				cnt = 0;
			}
		}
		System.out.println(sb);
	}
	public static void changeLights(int sex, int num){
		if (sex == 1) {
			for (int i = num; i < N+1; i += num) {
				onOff(i);
			}
		} else {
			onOff(num);
			for (int i = 1; i < N+1; i++) {
				if (num+i >= N+1 || num-i <= 0) break;
				if (lights[num+i] != lights[num-i]) break;
				onOff(num+i);
				onOff(num-i);
			}
		}
	}

	private static void onOff(int i) {
		if (lights[i] == 0) {
			lights[i]++;
		} else {
			lights[i]--;
		}
	}
}
