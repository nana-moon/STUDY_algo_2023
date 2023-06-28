import java.util.*;
import java.io.*;
public class Main {
	static int N, K, belt[], start, end, cnt;
	static boolean robot[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N]; // 내구도 array

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		robot = new boolean[N];

		// System.out.println(Arrays.toString(belt));
		cnt = 0; // 내구도가 0인 칸의 개수
		int level = 0;
		start = 0;
		end = N-1;

		while (cnt < K) {
			level++;
			// 벨트 이동
			move_belt();

			// 로봇 이동
			move_robot();

			// 새로운 로봇 올리기
			new_robot();
		}
		System.out.println(level);
	}



	private static void move_belt() {

		start --;
		end--;
		if (start == -1) start = 2*N-1;
		else if (end == -1) end = 2*N-1;

		for (int i = N-2; i >= 0; i--) {
			if (robot[i]) {
				robot[i] = false;
				if (i+1 < N-1) {
					robot[i+1] = true;
				}

			}
		}
	}
	private static void move_robot() {

		for (int i = N-2; i >= 0;i--) {
			int point = start+i+1;
			if (point >= 2*N) point -= 2*N;
			// 움직일 수 있음
			if (robot[i] && !robot[i+1] && belt[point] > 0) {
				robot[i] = false;
				robot[i+1] = true;
				belt[point]--;
				if (belt[point] == 0) cnt++;
			}
		}
		if (robot[N-1]) robot[N-1] = false;
	}
	private static void new_robot() {
		if ( belt[start] > 0) {
			belt[start]--;
			if (belt[start] == 0) cnt++;
			robot[0] = true;
		}
	}
}
