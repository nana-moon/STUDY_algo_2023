import java.util.*;
import java.io.*;
// 랜선자르기
public class Main {
	public static int N;
	public static int K;
	public static long[] lan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사용법 알아두기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new long[K];
		int max = 0;
		for (int i = 0; i < K; i ++) {
			int input = Integer.parseInt(br.readLine());
			lan[i] = input;
			max = Math.max(max, input);
		}

		// upperbound (초과하는 값 최초로 나타나는 위치 구하기)
		long start = 1;
		

		// start < end >> 탐색범위 밖에 end가 있는 경우!!! 둘이 같아 질 때 리턴된다.
		long end = max;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (counted_lan(mid) < N) {
				end = mid-1; // mid가 정답이 될 확률이 없음
			} else {
				start = mid+1; //mid가 정답이 될 수도 있음

			}
		}
		System.out.println(end);
		
		
	}

	private static int counted_lan(long len) {
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += lan[i] / len;
		}
		return cnt;
	}
}
