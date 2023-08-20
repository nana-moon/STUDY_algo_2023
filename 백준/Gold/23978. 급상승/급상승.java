import java.io.*;
import java.util.*;
public class Main {
	static int N, days[];
	static long K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		days = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}
		// 1~K사이의 수 중에 X를 찾기
		// lowerbound 값 찾기 최초로 K 보다 크거나 같은 값을 리턴하는 값 출력
		long start = 1;
		long end = 1500000000;
		while (start <= end) {
			long mid = (start + end) / 2;
			long result = toMoney(mid);
			if (result >= K) {
				end = mid -1;
			} else if(result < K) {
				start = mid +1;
			}
		}
		// start가 정답
		System.out.println(start);
	}
	public static long toMoney(long x) {
		long result = 0;
		for(int i = 1; i < N; i++) {
			int gap = days[i] - days[i-1];
			if(gap >= x) {
				// 1~x 까지의 합 더해주면 됨
				result += (1+x)*x/2;
			} else {
				// x-gap+1 ~ x 까지의 합 더해주면 됨
				result += (2*x-gap+1)*(gap)/2;
			}
		}
		result += (1+x)*x/2;
		return result;
	}
}